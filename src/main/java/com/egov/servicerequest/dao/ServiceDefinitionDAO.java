package com.egov.servicerequest.dao;

import com.egov.servicerequest.model.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jooq.*;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.impl.DSL;
import org.postgresql.util.PGobject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

@Repository
public class ServiceDefinitionDAO {
    Logger logger = LoggerFactory.getLogger(ServiceDefinitionDAO.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ServiceDefinitionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Transactional
    public ServiceDefinition save(ServiceDefinition serviceDefinition) {
        try {
            if(serviceDefinition.getId() == null) {
                serviceDefinition.setId(UUID.randomUUID().toString());
            }
            //save Audit.
            AuditDetails ad = serviceDefinition.getAuditDetails();
            int auditId = saveAuditDetails(ad);
            //get additional details.
            PGobject jsonObject = null;
            Object additionalDetails = serviceDefinition.getAdditionalDetails();
            if (additionalDetails instanceof JsonObject) {
                jsonObject = new PGobject();
                jsonObject.setType("json");
                jsonObject.setValue(additionalDetails.toString());
            }

            //save service definition
            logger.info("saving service definition");
            String serviceDefinitionInsertSql = "INSERT INTO service_definition (id, tenant_id, code, is_active, audit_details_id, client_id, additional_details) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PGobject tempJsonObj = jsonObject;
            Boolean result = jdbcTemplate.execute(serviceDefinitionInsertSql, new PreparedStatementCallback<Boolean>() {
                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setString(1, serviceDefinition.getId());
                    ps.setString(2, serviceDefinition.getTenantId());
                    ps.setString(3, serviceDefinition.getCode());
                    ps.setBoolean(4, serviceDefinition.getIsActive());
                    ps.setInt(5, auditId);
                    ps.setString(6, serviceDefinition.getClientId());
                    ps.setObject(7, tempJsonObj);
                    return ps.execute();
                }
            });

            //save attributeDefinition
            List<AttributeDefinition> attributeDefinitionList = serviceDefinition.getAttributes();
            if(attributeDefinitionList != null && attributeDefinitionList.size() > 0) {
                saveAttributeDefinitionList(attributeDefinitionList, auditId, jsonObject, serviceDefinition.getId());
            }
            return serviceDefinition;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Transactional
    public int saveAuditDetails(AuditDetails auditDetails) {
        logger.info("saving Audit details");
        String auditDetailsInsertSql = "INSERT INTO audit_details (created_by, last_modified_by, created_time, last_modified_time) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(auditDetailsInsertSql, new String[] {"id"});
                ps.setString(1, auditDetails.getCreatedBy());
                ps.setString(2, auditDetails.getLastModifiedBy());
                ps.setTimestamp(3, new Timestamp(auditDetails.getCreatedTime()));
                ps.setTimestamp(4, new Timestamp(auditDetails.getLastModifiedTime()));
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Transactional
    public void saveAttributeDefinitionList(List<AttributeDefinition> attributeDefinitionList, int auditId, PGobject jsonObject, String serviceDefinitionId) {
        logger.info("saving Attribute Definition for service definition");
        String attributeDefinitionInsertSql = "INSERT INTO attribute_definition (id, tenant_id, code, data_type, is_active, required, regEx, \"order\", audit_details_id, additional_details, service_definition_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Boolean.TRUE.equals(jdbcTemplate.execute(attributeDefinitionInsertSql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                int i = 0;
                for(AttributeDefinition attributeDefinition : attributeDefinitionList) {
                    if(attributeDefinition.getId() == null) attributeDefinition.setId(UUID.randomUUID().toString());
                    ps.setString(1, attributeDefinition.getId());
                    ps.setString(2, attributeDefinition.getTenantId());
                    ps.setString(3, attributeDefinition.getCode());
                    ps.setString(4, attributeDefinition.getDataType().toString());
                    ps.setBoolean(5, attributeDefinition.getIsActive());
                    ps.setBoolean(6, attributeDefinition.getRequired());
                    ps.setString(7, attributeDefinition.getRegEx());
                    ps.setString(8, attributeDefinition.getOrder());
                    ps.setInt(9, auditId);
                    ps.setObject(10, jsonObject);
                    ps.setString(11, serviceDefinitionId);
                    ps.addBatch();
                    i++;
                    if(i%1000 == 0 || i == attributeDefinitionList.size()) ps.executeBatch();
                }
                return Boolean.TRUE;
            }
        }));
    }

    public List<ServiceDefinition> findByServiceDefinitionCriteria(@NotNull ServiceDefinitionCriteria serviceDefinitionCriteria, Pagination pagination) {
        logger.info("getting service definition by criteria");
        //generating where conditions
        Map<Field<?>, Object> map = new HashMap<>();
        Condition condition = DSL.trueCondition();
        if(serviceDefinitionCriteria.getClientId() != null) condition = (field("sd.client_id").eq(serviceDefinitionCriteria.getClientId()));
        if(serviceDefinitionCriteria.getTenantId() != null) condition = condition.and(field("sd.tenant_id").eq(serviceDefinitionCriteria.getTenantId()));
        if(serviceDefinitionCriteria.getIds() != null && serviceDefinitionCriteria.getIds().size() > 0)
            condition = condition.and(field("sd.id").in(String.join("','", serviceDefinitionCriteria.getIds())));
        if(serviceDefinitionCriteria.getCode() != null && serviceDefinitionCriteria.getCode().size() > 0)
            condition = condition.and(field("sd.code").in(String.join("','", serviceDefinitionCriteria.getCode())));

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
        }

        Query query = context.select(field("sd.id service_definition_id"),
                        field("sd.tenant_id"),
                        field("sd.code"),
                        field("sd.is_active service_definition_is_active"),
                        field("sd.audit_details_id"),
                        field("sd.additional_details service_definition_additional_details"),
                        field("sd.client_id service_definition_client_id"),
                        field("ad.created_by audit_details_created_by"),
                        field("ad.last_modified_by audit_details_last_modified_by"),
                        field("ad.created_time audit_details_created_time"),
                        field("ad.last_modified_time audit_details_last_modified_time"),
                        field("ad2.id attribute_definition_id"),
                        field("ad2.data_type attribute_definition_data_type"),
                        field("ad2.values attribute_definition_values"),
                        field("ad2.is_active attribute_definition_is_active"),
                        field("ad2.required attribute_definition_required"),
                        field("ad2.regex attribute_definition_regex"),
                        field("ad2.order attribute_definition_order"),
                        field("ad2.additional_details attribute_definition_additional_details"))
                .from(table("service_definition as sd"))
                .leftJoin("audit_details as ad").on(field("sd.audit_details_id").eq(field("ad.id")))
                .leftJoin("attribute_definition as ad2").on(field("sd.id").eq(field("ad2.service_definition_id"))
                        .and(field("sd.tenant_id").eq(field("ad2.tenant_id"))))
                .where(condition)
                .limit(DSL.inline(limit))
                .offset(DSL.inline(offset));

        Map<String, ServiceDefinition> serviceDefinitionMap = new HashMap<>();
        jdbcTemplate.query(query.getSQL(),rs -> {
            String serviceDefinitionId = rs.getString("service_definition_id");
            int auditDetailsId = rs.getInt("audit_details_id");
            ServiceDefinition sd = serviceDefinitionMap.get(serviceDefinitionId);
            if(sd == null) {
                sd = new ServiceDefinition();
                sd.setId(serviceDefinitionId);
                sd.setTenantId(rs.getString("tenant_id"));
                sd.setCode(rs.getString("code"));
                sd.setClientId(rs.getString("service_definition_client_id"));
                sd.setIsActive(rs.getBoolean("service_definition_is_active"));
                String additional = rs.getString("service_definition_additional_details");
                JsonObject additionalDetails = new JsonObject();
                if(additional != null) {
                    additionalDetails = new Gson().fromJson(additional, JsonObject.class);
                    sd.setAdditionalDetails(additionalDetails);
                }
                serviceDefinitionMap.put(serviceDefinitionId, sd);
            }
            if(auditDetailsId == 0) {
                sd.setAuditDetails(null);
            } else {
                AuditDetails ad = new AuditDetails();
                ad.setCreatedBy(rs.getString("audit_details_created_by"));
                ad.setLastModifiedBy(rs.getString("audit_details_last_modified_by"));
                ad.setCreatedTime(rs.getTimestamp("audit_details_created_time").getTime());
                ad.lastModifiedTime(rs.getTimestamp("audit_details_last_modified_time").getTime());
                sd.setAuditDetails(ad);
            }
            AttributeDefinition attributeDefinition = new AttributeDefinition();
            attributeDefinition.setId(rs.getString("attribute_definition_id"));
            attributeDefinition.setTenantId(sd.getTenantId());
            attributeDefinition.setCode(sd.getCode());
            String dataType = rs.getString("attribute_definition_data_type");
            if(dataType != null) attributeDefinition.setDataType(AttributeDefinition.DataTypeEnum.fromValue(dataType));
            attributeDefinition.setIsActive(rs.getBoolean("attribute_definition_is_active"));
            attributeDefinition.setRequired(rs.getBoolean("attribute_definition_required"));
            attributeDefinition.setAuditDetails(sd.getAuditDetails());
            attributeDefinition.setOrder(rs.getString("attribute_definition_order"));
            attributeDefinition.setRegEx(rs.getString("attribute_definition_regex"));

            sd.addAttributesItem(attributeDefinition);

        });

        List<ServiceDefinition> result = new ArrayList<>(serviceDefinitionMap.values());
        return result != null && result.size() > 0 ? result : Collections.emptyList();
    }

    public Boolean checkIfServiceDefinitionExist(String serviceDefId) {
        logger.info("check if serviceDefinition id exist");
        String sql = "SELECT id FROM service_definition where id = '" + serviceDefId + "'";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        return rows.size() > 0;
    }
}
