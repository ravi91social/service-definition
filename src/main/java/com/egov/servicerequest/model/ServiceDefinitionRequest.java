package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.RequestInfo;
import com.egov.servicerequest.model.ServiceDefinition;
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
 * ServiceDefinitionRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class ServiceDefinitionRequest {

  private RequestInfo requestInfo;

  private ServiceDefinition serviceDefinition;

  /**
   * Default constructor
   * @deprecated Use {@link ServiceDefinitionRequest#ServiceDefinitionRequest(RequestInfo, ServiceDefinition)}
   */
  @Deprecated
  public ServiceDefinitionRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ServiceDefinitionRequest(RequestInfo requestInfo, ServiceDefinition serviceDefinition) {
    this.requestInfo = requestInfo;
    this.serviceDefinition = serviceDefinition;
  }

  public ServiceDefinitionRequest requestInfo(RequestInfo requestInfo) {
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

  public ServiceDefinitionRequest serviceDefinition(ServiceDefinition serviceDefinition) {
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
  public ServiceDefinition getServiceDefinition() {
    return serviceDefinition;
  }

  public void setServiceDefinition(ServiceDefinition serviceDefinition) {
    this.serviceDefinition = serviceDefinition;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceDefinitionRequest serviceDefinitionRequest = (ServiceDefinitionRequest) o;
    return Objects.equals(this.requestInfo, serviceDefinitionRequest.requestInfo) &&
        Objects.equals(this.serviceDefinition, serviceDefinitionRequest.serviceDefinition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestInfo, serviceDefinition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceDefinitionRequest {\n");
    sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
    sb.append("    serviceDefinition: ").append(toIndentedString(serviceDefinition)).append("\n");
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

