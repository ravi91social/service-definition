package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.AuditDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
 * Hold the attribute definition fields details as json object.
 */

@Schema(name = "AttributeDefinition", description = "Hold the attribute definition fields details as json object.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class AttributeDefinition {

  private String id;

  private String tenantId;

  private String code;

  /**
   * defines the attribute type
   */
  public enum DataTypeEnum {
    STRING("String"),
    
    NUMBER("Number"),
    
    TEXT("Text"),
    
    DATETIME("Datetime"),
    
    SINGLEVALUELIST("SingleValueList"),
    
    MULTIVALUELIST("MultiValueList"),
    
    FILE("File");

    private String value;

    DataTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DataTypeEnum fromValue(String value) {
      for (DataTypeEnum b : DataTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private DataTypeEnum dataType;

  @Valid
  private List<String> values;

  private Boolean isActive = true;

  private Boolean required;

  private String regEx;

  private String order;

  private AuditDetails auditDetails;

  private Object additionalDetails;

  /**
   * Default constructor
   * @deprecated Use {@link AttributeDefinition#AttributeDefinition(String, DataTypeEnum, Boolean)}
   */
  @Deprecated
  public AttributeDefinition() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AttributeDefinition(String code, DataTypeEnum dataType, Boolean isActive) {
    this.code = code;
    this.dataType = dataType;
    this.isActive = isActive;
  }

  public AttributeDefinition id(String id) {
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

  public AttributeDefinition tenantId(String tenantId) {
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

  public AttributeDefinition code(String code) {
    this.code = code;
    return this;
  }

  /**
   * unique code of attribute.
   * @return code
  */
  @NotNull @Size(min = 2, max = 64) 
  @Schema(name = "code", description = "unique code of attribute.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public AttributeDefinition dataType(DataTypeEnum dataType) {
    this.dataType = dataType;
    return this;
  }

  /**
   * defines the attribute type
   * @return dataType
  */
  @NotNull 
  @Schema(name = "dataType", description = "defines the attribute type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dataType")
  public DataTypeEnum getDataType() {
    return dataType;
  }

  public void setDataType(DataTypeEnum dataType) {
    this.dataType = dataType;
  }

  public AttributeDefinition values(List<String> values) {
    this.values = values;
    return this;
  }

  public AttributeDefinition addValuesItem(String valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<>();
    }
    this.values.add(valuesItem);
    return this;
  }

  /**
   * values we can pass if field type is selected as('singlevaluelist','multivaluelist'). 
   * @return values
  */
  
  @Schema(name = "values", description = "values we can pass if field type is selected as('singlevaluelist','multivaluelist'). ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("values")
  public List<String> getValues() {
    return values;
  }

  public void setValues(List<String> values) {
    this.values = values;
  }

  public AttributeDefinition isActive(Boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  /**
   * if the value is true then the attribute will appear in search
   * @return isActive
  */
  @NotNull 
  @Schema(name = "isActive", description = "if the value is true then the attribute will appear in search", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("isActive")
  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public AttributeDefinition required(Boolean required) {
    this.required = required;
    return this;
  }

  /**
   * value will be true if field is mandatory otherwise false.
   * @return required
  */
  
  @Schema(name = "required", description = "value will be true if field is mandatory otherwise false.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("required")
  public Boolean getRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public AttributeDefinition regEx(String regEx) {
    this.regEx = regEx;
    return this;
  }

  /**
   * Define the regular expression for field data validations
   * @return regEx
  */
  @Size(min = 2, max = 64) 
  @Schema(name = "regEx", description = "Define the regular expression for field data validations", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("regEx")
  public String getRegEx() {
    return regEx;
  }

  public void setRegEx(String regEx) {
    this.regEx = regEx;
  }

  public AttributeDefinition order(String order) {
    this.order = order;
    return this;
  }

  /**
   * order of the attributes for FE support
   * @return order
  */
  
  @Schema(name = "order", description = "order of the attributes for FE support", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("order")
  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public AttributeDefinition auditDetails(AuditDetails auditDetails) {
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

  public AttributeDefinition additionalDetails(Object additionalDetails) {
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
    AttributeDefinition attributeDefinition = (AttributeDefinition) o;
    return Objects.equals(this.id, attributeDefinition.id) &&
        Objects.equals(this.tenantId, attributeDefinition.tenantId) &&
        Objects.equals(this.code, attributeDefinition.code) &&
        Objects.equals(this.dataType, attributeDefinition.dataType) &&
        Objects.equals(this.values, attributeDefinition.values) &&
        Objects.equals(this.isActive, attributeDefinition.isActive) &&
        Objects.equals(this.required, attributeDefinition.required) &&
        Objects.equals(this.regEx, attributeDefinition.regEx) &&
        Objects.equals(this.order, attributeDefinition.order) &&
        Objects.equals(this.auditDetails, attributeDefinition.auditDetails) &&
        Objects.equals(this.additionalDetails, attributeDefinition.additionalDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tenantId, code, dataType, values, isActive, required, regEx, order, auditDetails, additionalDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributeDefinition {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    regEx: ").append(toIndentedString(regEx)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
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

