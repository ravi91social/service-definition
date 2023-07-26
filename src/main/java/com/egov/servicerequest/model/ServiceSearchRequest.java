package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.Pagination;
import com.egov.servicerequest.model.RequestInfo;
import com.egov.servicerequest.model.ServiceCriteria;
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
 * ServiceSearchRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class ServiceSearchRequest {

  private RequestInfo requestInfo;

  private ServiceCriteria serviceDefinition;

  private Pagination pagination;

  /**
   * Default constructor
   * @deprecated Use {@link ServiceSearchRequest#ServiceSearchRequest(RequestInfo, ServiceCriteria)}
   */
  @Deprecated
  public ServiceSearchRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ServiceSearchRequest(RequestInfo requestInfo, ServiceCriteria serviceDefinition) {
    this.requestInfo = requestInfo;
    this.serviceDefinition = serviceDefinition;
  }

  public ServiceSearchRequest requestInfo(RequestInfo requestInfo) {
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

  public ServiceSearchRequest serviceDefinition(ServiceCriteria serviceDefinition) {
    this.serviceDefinition = serviceDefinition;
    return this;
  }

  /**
   * Get serviceDefinition
   * @return serviceDefinition
  */
  @NotNull @Valid 
  @Schema(name = "serviceDefinition", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("serviceDefinition")
  public ServiceCriteria getServiceDefinition() {
    return serviceDefinition;
  }

  public void setServiceDefinition(ServiceCriteria serviceDefinition) {
    this.serviceDefinition = serviceDefinition;
  }

  public ServiceSearchRequest pagination(Pagination pagination) {
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
    ServiceSearchRequest serviceSearchRequest = (ServiceSearchRequest) o;
    return Objects.equals(this.requestInfo, serviceSearchRequest.requestInfo) &&
        Objects.equals(this.serviceDefinition, serviceSearchRequest.serviceDefinition) &&
        Objects.equals(this.pagination, serviceSearchRequest.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestInfo, serviceDefinition, pagination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSearchRequest {\n");
    sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
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

