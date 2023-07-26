package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.AttributeValue;
import com.egov.servicerequest.model.AuditDetails;
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
 * Hold the Service field details as json object.
 */

@Schema(name = "Service", description = "Hold the Service field details as json object.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class Service {

  private String id;

  private String tenantId;

  private String serviceDefId;

  private String referenceId;

  private String accountId;

  private String clientId;

  @Valid
  private List<@Valid AttributeValue> attributes = new ArrayList<>();

  private AuditDetails auditDetails;

  private Object additionalDetails;

  /**
   * Default constructor
   * @deprecated Use {@link Service#Service(String, String, String, List<@Valid AttributeValue>)}
   */
  @Deprecated
  public Service() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Service(String tenantId, String serviceDefId, String accountId, List<@Valid AttributeValue> attributes) {
    this.tenantId = tenantId;
    this.serviceDefId = serviceDefId;
    this.accountId = accountId;
    this.attributes = attributes;
  }

  public Service id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the record
   * @return id
  */
  
  @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, description = "Unique identifier of the record", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Service tenantId(String tenantId) {
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

  public Service serviceDefId(String serviceDefId) {
    this.serviceDefId = serviceDefId;
    return this;
  }

  /**
   * Service definition id
   * @return serviceDefId
  */
  @NotNull @Size(min = 2, max = 64) 
  @Schema(name = "serviceDefId", description = "Service definition id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("serviceDefId")
  public String getServiceDefId() {
    return serviceDefId;
  }

  public void setServiceDefId(String serviceDefId) {
    this.serviceDefId = serviceDefId;
  }

  public Service referenceId(String referenceId) {
    this.referenceId = referenceId;
    return this;
  }

  /**
   * if service is delivered for specific entity then we link this to that entity
   * @return referenceId
  */
  @Size(min = 2, max = 64) 
  @Schema(name = "referenceId", description = "if service is delivered for specific entity then we link this to that entity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("referenceId")
  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public Service accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Account id of the individual
   * @return accountId
  */
  @NotNull @Size(min = 2, max = 64) 
  @Schema(name = "accountId", description = "Account id of the individual", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("accountId")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public Service clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * Client Id for service
   * @return clientId
  */
  @Size(min = 2, max = 64) 
  @Schema(name = "clientId", description = "Client Id for service", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clientId")
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public Service attributes(List<@Valid AttributeValue> attributes) {
    this.attributes = attributes;
    return this;
  }

  public Service addAttributesItem(AttributeValue attributesItem) {
    if (this.attributes == null) {
      this.attributes = new ArrayList<>();
    }
    this.attributes.add(attributesItem);
    return this;
  }

  /**
   * values we can pass if field type is selected as('singlevaluelist','multivaluelist'). 
   * @return attributes
  */
  @NotNull @Valid 
  @Schema(name = "attributes", description = "values we can pass if field type is selected as('singlevaluelist','multivaluelist'). ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("attributes")
  public List<@Valid AttributeValue> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<@Valid AttributeValue> attributes) {
    this.attributes = attributes;
  }

  public Service auditDetails(AuditDetails auditDetails) {
    this.auditDetails = auditDetails;
    return this;
  }

  /**
   * Get auditDetails
   * @return auditDetails
  */
  @Valid 
  @Schema(name = "auditDetails", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("auditDetails")
  public AuditDetails getAuditDetails() {
    return auditDetails;
  }

  public void setAuditDetails(AuditDetails auditDetails) {
    this.auditDetails = auditDetails;
  }

  public Service additionalDetails(Object additionalDetails) {
    this.additionalDetails = additionalDetails;
    return this;
  }

  /**
   * Any additional key-value pair to be stored with the service.
   * @return additionalDetails
  */
  
  @Schema(name = "additionalDetails", description = "Any additional key-value pair to be stored with the service.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("additionalDetails")
  public Object getAdditionalDetails() {
    return additionalDetails;
  }

  public void setAdditionalDetails(Object additionalDetails) {
    this.additionalDetails = additionalDetails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Service service = (Service) o;
    return Objects.equals(this.id, service.id) &&
        Objects.equals(this.tenantId, service.tenantId) &&
        Objects.equals(this.serviceDefId, service.serviceDefId) &&
        Objects.equals(this.referenceId, service.referenceId) &&
        Objects.equals(this.accountId, service.accountId) &&
        Objects.equals(this.clientId, service.clientId) &&
        Objects.equals(this.attributes, service.attributes) &&
        Objects.equals(this.auditDetails, service.auditDetails) &&
        Objects.equals(this.additionalDetails, service.additionalDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tenantId, serviceDefId, referenceId, accountId, clientId, attributes, auditDetails, additionalDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Service {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    serviceDefId: ").append(toIndentedString(serviceDefId)).append("\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    auditDetails: ").append(toIndentedString(auditDetails)).append("\n");
    sb.append("    additionalDetails: ").append(toIndentedString(additionalDetails)).append("\n");
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

