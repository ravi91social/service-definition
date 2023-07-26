package com.egov.servicerequest.dao;

import com.egov.servicerequest.model.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jooq.*;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.impl.DSL;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

@Repository
public class ServiceDAO {
    private JdbcTemplate jdbcTemplate;
    private ServiceDefinitionDAO serviceDefinitionDAO;

    @Autowired
    public ServiceDAO(JdbcTemplate jdbcTemplate, ServiceDefinitionDAO serviceDefinitionDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.serviceDefinitionDAO = serviceDefinitionDAO;
    }

    public Service save(Service service) {
        try {
            if(service.getId() == null) {
                service.setId(UUID.randomUUID().toString());
            }
            //save Audit.
            AuditDetails ad = service.getAuditDetails();
            int auditId = serviceDefinitionDAO.saveAuditDetails(ad);

            //get additional details.
            PGobject jsonObject = null;
            Object additionalDetails = service.getAdditionalDetails();
            if (additionalDetails instanceof JsonObject) {
                jsonObject = new PGobject();
                jsonObject.setType("json");
                jsonObject.setValue(additionalDetails.toString());
            }
            Boolean serviceDefIdExist =  serviceDefinitionDAO.checkIfServiceDefinitionExist(service.getServiceDefId());
            if(!serviceDefIdExist) {
                throw new RuntimeException("Wrong serviceDefinition Id");
            }
            String serviceInsertSql = "INSERT INTO service (id, tenant_id, service_definition_id, reference_id, account_id, client_id, audit_details_id, additional_details) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PGobject finalJsonObj1 = jsonObject;
            boolean result = Boolean.TRUE.equals(jdbcTemplate.execute(serviceInsertSql, new PreparedStatementCallback<Boolean>() {
                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setString(1, service.getId());
                    ps.setString(2, service.getTenantId());
                    ps.setString(3, service.getServiceDefId());
                    ps.setString(4, service.getReferenceId());
                    ps.setString(5, service.getAccountId());
                    ps.setString(6, service.getClientId());
                    ps.setInt(7, auditId);
                    ps.setObject(8, finalJsonObj1);
                    return ps.execute();
                }
            }));

            List<AttributeValue> attributeValueList = service.getAttributes();
            if(attributeValueList != null && attributeValueList.size() > 0) {
                saveAttributeValueList(service, attributeValueList, auditId, jsonObject);
            }

            return service;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void saveAttributeValueList(Service service, List<AttributeValue> attributeValueList, int auditId, PGobject jsonObject) {
        String attributeDefinitionInsertSql = "INSERT INTO attribute_value (id, attribute_code, value, audit_details_id, additional_details, service_id) VALUES (?, ?, ?::jsonb, ?, ?, ?)";
        PGobject finalJsonObj = jsonObject;
        Boolean.TRUE.equals(jdbcTemplate.execute(attributeDefinitionInsertSql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                int i = 0;
                for(AttributeValue attributeValue : attributeValueList) {
                    if(attributeValue.getId() == null) attributeValue.setId(UUID.randomUUID().toString());
                    ps.setString(1, attributeValue.getId());
                    ps.setString(2, attributeValue.getAttributeCode());
                    ps.setObject(3, attributeValue.getValue().toString());
                    ps.setInt(4, auditId);
                    ps.setObject(5, finalJsonObj);
                    ps.setString(6, service.getId());
                    ps.addBatch();
                    i++;
                    if(i%1000 == 0 || i == attributeValueList.size()) ps.executeBatch();
                }
                return Boolean.TRUE;
            }
        }));
    }

    public List<Service> findByServiceCriteria(ServiceCriteria serviceCriteria, Pagination pagination)  {

        //generating where conditions
        Map<Field<?>, Object> map = new HashMap<>();
        Condition condition = DSL.trueCondition();
        if(serviceCriteria.getClientId()!= null) condition = (field("s.client_id").eq(serviceCriteria.getClientId()));
        if(serviceCriteria.getTenantId() != null) condition = condition.and(field("s.tenant_id").eq(serviceCriteria.getTenantId()));
        if(serviceCriteria.getAccountId() != null) condition = condition.and(field("s.account_id").eq(serviceCriteria.getClientId()));
        if(serviceCriteria.getIds() != null && serviceCriteria.getIds().size() > 0)
            condition = condition.and(field("s.id").in(String.join("','", String.join("','", serviceCriteria.getIds()))));
        if(serviceCriteria.getReferenceIds() != null && serviceCriteria.getReferenceIds().size() > 0)
            condition = condition.and(field("s.reference_id").in(String.join("','", String.join("','", serviceCriteria.getReferenceIds()))));
        if(serviceCriteria.getServiceDefIds() != null && serviceCriteria.getServiceDefIds().size() > 0) {
            condition = condition.and(field("s.service_definition_id").in(String.join("','", serviceCriteria.getServiceDefIds())));
        }

        //generating limit offset.
        Long limit = 10L;
        Long offset = 0L;
        if(pagination != null) {
            limit = !(BigDecimal.ZERO.equals(pagination.getLimit())) ? pagination.getLimit().longValue() : limit;
            offset = !(BigDecimal.ZERO.equals(pagination.getOffSet())) ? pagination.getOffSet().longValue() : offset;
        }

        //generating query
        DSLContext context =  null;
        try {
            context = DSL.using(jdbcTemplate.getDataSource().getConnection(), SQLDialect.POSTGRES,
                    new Settings().withStatementType(StatementType.STATIC_STATEMENT));
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        };
        Query query = context.select(field("s.id service_id"),
                        field("s.tenant_id"),
                        field("s.service_definition_id"),
                        field("s.reference_id"),
                        field("s.account_id"),
                        field("s.client_id"),
                        field("s.audit_details_id"),
                        field("s.additional_details"),
                        field("ad.created_by audit_details_created_by"),
                        field("ad.last_modified_by audit_details_last_modified_by"),
                        field("ad.created_time audit_details_created_time"),
                        field("ad.last_modified_time audit_details_last_modified_time"),
                        field("av.id service_value_id"),
                        field("av.attribute_code service_value_attribute_code"),
                        field("av.value service_value_value"),
                        field("av.service_id service_value_service_id"),
                        field("av.additional_details  service_value_additional_details"))
                .from(table("service s"))
                .leftJoin("audit_details ad").on(field("s.audit_details_id").eq(field("ad.id")))
                .leftJoin("service_definition sd").on(field("s.service_definition_id").eq(field("sd.id")))
                .leftJoin("attribute_value av").on(field("av.service_id").eq(field("s.id")))
                .where(condition)
                .limit(DSL.inline(limit))
                .offset(DSL.inline(offset));

        Map<String, Service> serviceMap = new HashMap<>();
        jdbcTemplate.query(query.getSQL(),rs -> {
            String serviceId = rs.getString("service_id");
            String serviceDefinitionId = rs.getString("service_definition_id");
            int auditDetailsId = rs.getInt("audit_details_id");
            Service service = serviceMap.get(serviceDefinitionId);
            JsonObject additionalDetails = new JsonObject();
            if(service == null) {
                service = new Service();
                service.setId(serviceId);
                service.setTenantId(rs.getString("tenant_id"));
                service.setAccountId(rs.getString("account_id"));
                service.setClientId(rs.getString("client_id"));
                service.setServiceDefId(rs.getString("service_definition_id"));
                service.setReferenceId(rs.getString("reference_id"));
                String additional = rs.getString("service_value_additional_details");
                if(additional != null) {
                    additionalDetails = new Gson().fromJson(additional, JsonObject.class);
                    service.setAdditionalDetails(additionalDetails);
                }
                serviceMap.put(serviceId, service);
            }
            if(auditDetailsId == 0) {
                service.setAuditDetails(null);
            } else {
                AuditDetails ad = new AuditDetails();
                ad.setCreatedBy(rs.getString("audit_details_created_by"));
                ad.setLastModifiedBy(rs.getString("audit_details_last_modified_by"));
                ad.setCreatedTime(rs.getTimestamp("audit_details_created_time").getTime());
                ad.lastModifiedTime(rs.getTimestamp("audit_details_last_modified_time").getTime());
                service.setAuditDetails(ad);
            }
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setId(rs.getString("service_value_id"));
            attributeValue.setAttributeCode(rs.getString("service_value_attribute_code"));
            attributeValue.setAdditionalDetails(additionalDetails);
            attributeValue.setValue(rs.getObject("service_value_value"));
            attributeValue.setAuditDetails(service.getAuditDetails());
            service.addAttributesItem(attributeValue);
        });

        List<Service> result = new ArrayList<>(serviceMap.values());
        return result.size() > 0 ? result : Collections.emptyList();
    }
}
