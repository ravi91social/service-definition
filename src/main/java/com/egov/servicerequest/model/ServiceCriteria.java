package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * The object will contain all the search parameters for Service .
 */

@Schema(name = "ServiceCriteria", description = "The object will contain all the search parameters for Service .")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class ServiceCriteria {

  private String tenantId;

  @Valid
  private List<String> ids;

  @Valid
  private List<String> serviceDefIds;

  @Valid
  private List<String> referenceIds;

  private String accountId;

  private String clientId;

  private Object value;

  /**
   * Default constructor
   * @deprecated Use {@link ServiceCriteria#ServiceCriteria(String)}
   */
  @Deprecated
  public ServiceCriteria() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ServiceCriteria(String tenantId) {
    this.tenantId = tenantId;
  }

  public ServiceCriteria tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  /**
   * Tenant Identifier
   * @return tenantId
  */
  @NotNull @Size(min = 2, max = 64) 
  @Schema(name = "tenantId", example = "pb.amritsar", description = "Tenant Identifier", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tenantId")
  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public ServiceCriteria ids(List<String> ids) {
    this.ids = ids;
    return this;
  }

  public ServiceCriteria addIdsItem(String idsItem) {
    if (this.ids == null) {
      this.ids = new ArrayList<>();
    }
    this.ids.add(idsItem);
    return this;
  }

  /**
   * Search by service ids
   * @return ids
  */
  
  @Schema(name = "ids", description = "Search by service ids", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ids")
  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }

  public ServiceCriteria serviceDefIds(List<String> serviceDefIds) {
    this.serviceDefIds = serviceDefIds;
    return this;
  }

  public ServiceCriteria addServiceDefIdsItem(String serviceDefIdsItem) {
    if (this.serviceDefIds == null) {
      this.serviceDefIds = new ArrayList<>();
    }
    this.serviceDefIds.add(serviceDefIdsItem);
    return this;
  }

  /**
   * Search by service definition ids
   * @return serviceDefIds
  */
  
  @Schema(name = "serviceDefIds", description = "Search by service definition ids", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("serviceDefIds")
  public List<String> getServiceDefIds() {
    return serviceDefIds;
  }

  public void setServiceDefIds(List<String> serviceDefIds) {
    this.serviceDefIds = serviceDefIds;
  }

  public ServiceCriteria referenceIds(List<String> referenceIds) {
    this.referenceIds = referenceIds;
    return this;
  }

  public ServiceCriteria addReferenceIdsItem(String referenceIdsItem) {
    if (this.referenceIds == null) {
      this.referenceIds = new ArrayList<>();
    }
    this.referenceIds.add(referenceIdsItem);
    return this;
  }

  /**
   * Search by service reference ids
   * @return referenceIds
  */
  
  @Schema(name = "referenceIds", description = "Search by service reference ids", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("referenceIds")
  public List<String> getReferenceIds() {
    return referenceIds;
  }

  public void setReferenceIds(List<String> referenceIds) {
    this.referenceIds = referenceIds;
  }

  public ServiceCriteria accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Account Id of individual
   * @return accountId
  */
  @Size(min = 2, max = 64) 
  @Schema(name = "accountId", description = "Account Id of individual", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accountId")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public ServiceCriteria clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * Client Id
   * @return clientId
  */
  @Size(min = 2, max = 64) 
  @Schema(name = "clientId", description = "Client Id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clientId")
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public ServiceCriteria value(Object value) {
    this.value = value;
    return this;
  }

  /**
   * Search based on values provided in service
   * @return value
  */
  
  @Schema(name = "value", description = "Search based on values provided in service", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("value")
  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceCriteria serviceCriteria = (ServiceCriteria) o;
    return Objects.equals(this.tenantId, serviceCriteria.tenantId) &&
        Objects.equals(this.ids, serviceCriteria.ids) &&
        Objects.equals(this.serviceDefIds, serviceCriteria.serviceDefIds) &&
        Objects.equals(this.referenceIds, serviceCriteria.referenceIds) &&
        Objects.equals(this.accountId, serviceCriteria.accountId) &&
        Objects.equals(this.clientId, serviceCriteria.clientId) &&
        Objects.equals(this.value, serviceCriteria.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, ids, serviceDefIds, referenceIds, accountId, clientId, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCriteria {\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
    sb.append("    serviceDefIds: ").append(toIndentedString(serviceDefIds)).append("\n");
    sb.append("    referenceIds: ").append(toIndentedString(referenceIds)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

