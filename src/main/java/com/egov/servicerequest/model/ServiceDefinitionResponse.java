package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.Pagination;
import com.egov.servicerequest.model.ResponseInfo;
import com.egov.servicerequest.model.ServiceDefinition;
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
 * ServiceDefinitionResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class ServiceDefinitionResponse {

  private ResponseInfo responseInfo;

  @Valid
  private List<@Valid ServiceDefinition> serviceDefinition;

  private Pagination pagination;

  public ServiceDefinitionResponse responseInfo(ResponseInfo responseInfo) {
    this.responseInfo = responseInfo;
    return this;
  }

  /**
   * Get responseInfo
   * @return responseInfo
  */
  @Valid 
  @Schema(name = "responseInfo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("responseInfo")
  public ResponseInfo getResponseInfo() {
    return responseInfo;
  }

  public void setResponseInfo(ResponseInfo responseInfo) {
    this.responseInfo = responseInfo;
  }

  public ServiceDefinitionResponse serviceDefinition(List<@Valid ServiceDefinition> serviceDefinition) {
    this.serviceDefinition = serviceDefinition;
    return this;
  }

  public ServiceDefinitionResponse addServiceDefinitionItem(ServiceDefinition serviceDefinitionItem) {
    if (this.serviceDefinition == null) {
      this.serviceDefinition = new ArrayList<>();
    }
    this.serviceDefinition.add(serviceDefinitionItem);
    return this;
  }

  /**
   * Get serviceDefinition
   * @return serviceDefinition
  */
  @Valid 
  @Schema(name = "serviceDefinition", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("serviceDefinition")
  public List<@Valid ServiceDefinition> getServiceDefinition() {
    return serviceDefinition;
  }

  public void setServiceDefinition(List<@Valid ServiceDefinition> serviceDefinition) {
    this.serviceDefinition = serviceDefinition;
  }

  public ServiceDefinitionResponse pagination(Pagination pagination) {
    this.pagination = pagination;
    return this;
  }

  /**
   * Get pagination
   * @return pagination
  */
  @Valid 
  @Schema(name = "pagination", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pagination")
  public Pagination getPagination() {
    return pagination;
  }

  public void setPagination(Pagination pagination) {
    this.pagination = pagination;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceDefinitionResponse serviceDefinitionResponse = (ServiceDefinitionResponse) o;
    return Objects.equals(this.responseInfo, serviceDefinitionResponse.responseInfo) &&
        Objects.equals(this.serviceDefinition, serviceDefinitionResponse.serviceDefinition) &&
        Objects.equals(this.pagination, serviceDefinitionResponse.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseInfo, serviceDefinition, pagination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceDefinitionResponse {\n");
    sb.append("    responseInfo: ").append(toIndentedString(responseInfo)).append("\n");
    sb.append("    serviceDefinition: ").append(toIndentedString(serviceDefinition)).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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

