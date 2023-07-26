package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.Pagination;
import com.egov.servicerequest.model.RequestInfo;
import com.egov.servicerequest.model.ServiceDefinitionCriteria;
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
 * ServiceDefinitionSearchRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class ServiceDefinitionSearchRequest {

  private RequestInfo requestInfo;

  private ServiceDefinitionCriteria serviceDefinitionCriteria;

  private Pagination pagination;

  /**
   * Default constructor
   * @deprecated Use {@link ServiceDefinitionSearchRequest#ServiceDefinitionSearchRequest(RequestInfo)}
   */
  @Deprecated
  public ServiceDefinitionSearchRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ServiceDefinitionSearchRequest(RequestInfo requestInfo) {
    this.requestInfo = requestInfo;
  }

  public ServiceDefinitionSearchRequest requestInfo(RequestInfo requestInfo) {
    this.requestInfo = requestInfo;
    return this;
  }

  /**
   * Get requestInfo
   * @return requestInfo
  */
  @NotNull @Valid 
  @Schema(name = "requestInfo", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("requestInfo")
  public RequestInfo getRequestInfo() {
    return requestInfo;
  }

  public void setRequestInfo(RequestInfo requestInfo) {
    this.requestInfo = requestInfo;
  }

  public ServiceDefinitionSearchRequest serviceDefinitionCriteria(ServiceDefinitionCriteria serviceDefinitionCriteria) {
    this.serviceDefinitionCriteria = serviceDefinitionCriteria;
    return this;
  }

  /**
   * Get serviceDefinitionCriteria
   * @return serviceDefinitionCriteria
  */
  @Valid 
  @Schema(name = "serviceDefinitionCriteria", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("serviceDefinitionCriteria")
  public ServiceDefinitionCriteria getServiceDefinitionCriteria() {
    return serviceDefinitionCriteria;
  }

  public void setServiceDefinitionCriteria(ServiceDefinitionCriteria serviceDefinitionCriteria) {
    this.serviceDefinitionCriteria = serviceDefinitionCriteria;
  }

  public ServiceDefinitionSearchRequest pagination(Pagination pagination) {
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
    ServiceDefinitionSearchRequest serviceDefinitionSearchRequest = (ServiceDefinitionSearchRequest) o;
    return Objects.equals(this.requestInfo, serviceDefinitionSearchRequest.requestInfo) &&
        Objects.equals(this.serviceDefinitionCriteria, serviceDefinitionSearchRequest.serviceDefinitionCriteria) &&
        Objects.equals(this.pagination, serviceDefinitionSearchRequest.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestInfo, serviceDefinitionCriteria, pagination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceDefinitionSearchRequest {\n");
    sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
    sb.append("    serviceDefinitionCriteria: ").append(toIndentedString(serviceDefinitionCriteria)).append("\n");
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

