package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.RequestInfo;
import com.egov.servicerequest.model.Service;
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
 * ServiceRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class ServiceRequest {

  private RequestInfo requestInfo;

  private Service service;

  /**
   * Default constructor
   * @deprecated Use {@link ServiceRequest#ServiceRequest(RequestInfo)}
   */
  @Deprecated
  public ServiceRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ServiceRequest(RequestInfo requestInfo) {
    this.requestInfo = requestInfo;
  }

  public ServiceRequest requestInfo(RequestInfo requestInfo) {
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

  public ServiceRequest service(Service service) {
    this.service = service;
    return this;
  }

  /**
   * Get service
   * @return service
  */
  @Valid 
  @Schema(name = "service", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("service")
  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceRequest serviceRequest = (ServiceRequest) o;
    return Objects.equals(this.requestInfo, serviceRequest.requestInfo) &&
        Objects.equals(this.service, serviceRequest.service);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestInfo, service);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceRequest {\n");
    sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
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

