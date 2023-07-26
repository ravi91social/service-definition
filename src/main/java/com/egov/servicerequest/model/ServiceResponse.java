package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.Pagination;
import com.egov.servicerequest.model.ResponseInfo;
import com.egov.servicerequest.model.Service;
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
 * ServiceResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class ServiceResponse {

  private ResponseInfo responseInfo;

  @Valid
  private List<@Valid Service> service;

  private Pagination pagination;

  public ServiceResponse responseInfo(ResponseInfo responseInfo) {
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

  public ServiceResponse service(List<@Valid Service> service) {
    this.service = service;
    return this;
  }

  public ServiceResponse addServiceItem(Service serviceItem) {
    if (this.service == null) {
      this.service = new ArrayList<>();
    }
    this.service.add(serviceItem);
    return this;
  }

  /**
   * Get service
   * @return service
  */
  @Valid 
  @Schema(name = "service", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("service")
  public List<@Valid Service> getService() {
    return service;
  }

  public void setService(List<@Valid Service> service) {
    this.service = service;
  }

  public ServiceResponse pagination(Pagination pagination) {
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
    ServiceResponse serviceResponse = (ServiceResponse) o;
    return Objects.equals(this.responseInfo, serviceResponse.responseInfo) &&
        Objects.equals(this.service, serviceResponse.service) &&
        Objects.equals(this.pagination, serviceResponse.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseInfo, service, pagination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceResponse {\n");
    sb.append("    responseInfo: ").append(toIndentedString(responseInfo)).append("\n");
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
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

