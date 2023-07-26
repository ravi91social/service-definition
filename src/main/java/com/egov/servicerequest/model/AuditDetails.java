package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
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
 * Collection of audit related fields used by most models
 */

@Schema(name = "AuditDetails", description = "Collection of audit related fields used by most models")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class AuditDetails {

  private String createdBy;

  private String lastModifiedBy;

  private Long createdTime;

  private Long lastModifiedTime;

  public AuditDetails createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * username (preferred) or userid of the user that created the object
   * @return createdBy
  */
  
  @Schema(name = "createdBy", description = "username (preferred) or userid of the user that created the object", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdBy")
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public AuditDetails lastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
    return this;
  }

  /**
   * username (preferred) or userid of the user that last modified the object
   * @return lastModifiedBy
  */
  
  @Schema(name = "lastModifiedBy", description = "username (preferred) or userid of the user that last modified the object", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastModifiedBy")
  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }

  public AuditDetails createdTime(Long createdTime) {
    this.createdTime = createdTime;
    return this;
  }

  /**
   * epoch of the time object is created
   * @return createdTime
  */
  
  @Schema(name = "createdTime", description = "epoch of the time object is created", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdTime")
  public Long getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Long createdTime) {
    this.createdTime = createdTime;
  }

  public AuditDetails lastModifiedTime(Long lastModifiedTime) {
    this.lastModifiedTime = lastModifiedTime;
    return this;
  }

  /**
   * epoch of the time object is last modified
   * @return lastModifiedTime
  */
  
  @Schema(name = "lastModifiedTime", description = "epoch of the time object is last modified", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastModifiedTime")
  public Long getLastModifiedTime() {
    return lastModifiedTime;
  }

  public void setLastModifiedTime(Long lastModifiedTime) {
    this.lastModifiedTime = lastModifiedTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditDetails auditDetails = (AuditDetails) o;
    return Objects.equals(this.createdBy, auditDetails.createdBy) &&
        Objects.equals(this.lastModifiedBy, auditDetails.lastModifiedBy) &&
        Objects.equals(this.createdTime, auditDetails.createdTime) &&
        Objects.equals(this.lastModifiedTime, auditDetails.lastModifiedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdBy, lastModifiedBy, createdTime, lastModifiedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditDetails {\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    lastModifiedBy: ").append(toIndentedString(lastModifiedBy)).append("\n");
    sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
    sb.append("    lastModifiedTime: ").append(toIndentedString(lastModifiedTime)).append("\n");
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

