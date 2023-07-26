package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.AuditDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Hold the attribute details as object.
 */

@Schema(name = "AttributeValue", description = "Hold the attribute details as object.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class AttributeValue {

  private String id;

  private String attributeCode;

  private Object value;

  private AuditDetails auditDetails;

  private Object additionalDetails;

  /**
   * Default constructor
   * @deprecated Use {@link AttributeValue#AttributeValue(String, Object)}
   */
  @Deprecated
  public AttributeValue() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AttributeValue(String attributeCode, Object value) {
    this.attributeCode = attributeCode;
    this.value = value;
  }

  public AttributeValue id(String id) {
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

  public AttributeValue attributeCode(String attributeCode) {
    this.attributeCode = attributeCode;
    return this;
  }

  /**
   * Unique code of attribute from attributedefinition
   * @return attributeCode
  */
  @NotNull 
  @Schema(name = "attributeCode", description = "Unique code of attribute from attributedefinition", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("attributeCode")
  public String getAttributeCode() {
    return attributeCode;
  }

  public void setAttributeCode(String attributeCode) {
    this.attributeCode = attributeCode;
  }

  public AttributeValue value(Object value) {
    this.value = value;
    return this;
  }

  /**
   * values we can pass if field type is selected as('singlevaluelist','multivaluelist'). 
   * @return value
  */
  @NotNull 
  @Schema(name = "value", description = "values we can pass if field type is selected as('singlevaluelist','multivaluelist'). ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("value")
  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public AttributeValue auditDetails(AuditDetails auditDetails) {
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

  public AttributeValue additionalDetails(Object additionalDetails) {
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
    AttributeValue attributeValue = (AttributeValue) o;
    return Objects.equals(this.id, attributeValue.id) &&
        Objects.equals(this.attributeCode, attributeValue.attributeCode) &&
        Objects.equals(this.value, attributeValue.value) &&
        Objects.equals(this.auditDetails, attributeValue.auditDetails) &&
        Objects.equals(this.additionalDetails, attributeValue.additionalDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, attributeCode, value, auditDetails, additionalDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributeValue {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    attributeCode: ").append(toIndentedString(attributeCode)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

