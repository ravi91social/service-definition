package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.AttributeDefinition;
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
 * Holds the Service Definition details json object.
 */

@Schema(name = "ServiceDefinition", description = "Holds the Service Definition details json object.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class ServiceDefinition {

  private String id;

  private String tenantId;

  private String code;

  private Boolean isActive = true;

  @Valid
  private List<@Valid AttributeDefinition> attributes = new ArrayList<>();

  private AuditDetails auditDetails;

  private Object additionalDetails;

  private String clientId;

  /**
   * Default constructor
   * @deprecated Use {@link ServiceDefinition#ServiceDefinition(String, List<@Valid AttributeDefinition>)}
   */
  @Deprecated
  public ServiceDefinition() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ServiceDefinition(String code, List<@Valid AttributeDefinition> attributes) {
    this.code = code;
    this.attributes = attributes;
  }

  public ServiceDefinition id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the record
   * @return id
  */
  @Size(min = 2, max = 64) 
  @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, description = "Unique identifier of the record", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceDefinition tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  /**
   * Tenant Identifier
   * @return tenantId
  */
  @Size(min = 2, max = 64) 
  @Schema(name = "tenantId", example = "pb.amritsar", description = "Tenant Identifier", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tenantId")
  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public ServiceDefinition code(String code) {
    this.code = code;
    return this;
  }

  /**
   * unique namespaced service code to identify the attribute config for code
   * @return code
  */
  @NotNull @Size(min = 2, max = 64) 
  @Schema(name = "code", description = "unique namespaced service code to identify the attribute config for code", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ServiceDefinition isActive(Boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  /**
   * If false then consider this as soft deleted record
   * @return isActive
  */
  
  @Schema(name = "isActive", description = "If false then consider this as soft deleted record", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isActive")
  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public ServiceDefinition attributes(List<@Valid AttributeDefinition> attributes) {
    this.attributes = attributes;
    return this;
  }

  public ServiceDefinition addAttributesItem(AttributeDefinition attributesItem) {
    if (this.attributes == null) {
      this.attributes = new ArrayList<>();
    }
    this.attributes.add(attributesItem);
    return this;
  }

  /**
   * Get attributes
   * @return attributes
  */
  @NotNull @Valid 
  @Schema(name = "attributes", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("attributes")
  public List<@Valid AttributeDefinition> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<@Valid AttributeDefinition> attributes) {
    this.attributes = attributes;
  }

  public ServiceDefinition auditDetails(AuditDetails auditDetails) {
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

  public ServiceDefinition additionalDetails(Object additionalDetails) {
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

  public ServiceDefinition clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * Client Id for service definition
   * @return clientId
  */
  @Size(min = 2, max = 64) 
  @Schema(name = "clientId", description = "Client Id for service definition", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clientId")
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceDefinition serviceDefinition = (ServiceDefinition) o;
    return Objects.equals(this.id, serviceDefinition.id) &&
        Objects.equals(this.tenantId, serviceDefinition.tenantId) &&
        Objects.equals(this.code, serviceDefinition.code) &&
        Objects.equals(this.isActive, serviceDefinition.isActive) &&
        Objects.equals(this.attributes, serviceDefinition.attributes) &&
        Objects.equals(this.auditDetails, serviceDefinition.auditDetails) &&
        Objects.equals(this.additionalDetails, serviceDefinition.additionalDetails) &&
        Objects.equals(this.clientId, serviceDefinition.clientId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tenantId, code, isActive, attributes, auditDetails, additionalDetails, clientId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceDefinition {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    auditDetails: ").append(toIndentedString(auditDetails)).append("\n");
    sb.append("    additionalDetails: ").append(toIndentedString(additionalDetails)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
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

