package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.Error;
import com.egov.servicerequest.model.ResponseInfo;
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
 * All APIs will return ErrorRes in case of failure which will carry ResponseInfo as metadata and Error object as actual representation of error. In case of bulk apis, some apis may chose to return the array of Error objects to indicate individual failure.
 */

@Schema(name = "ErrorRes", description = "All APIs will return ErrorRes in case of failure which will carry ResponseInfo as metadata and Error object as actual representation of error. In case of bulk apis, some apis may chose to return the array of Error objects to indicate individual failure.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class ErrorRes {

  private ResponseInfo responseInfo;

  @Valid
  private List<@Valid Error> errors;

  /**
   * Default constructor
   * @deprecated Use {@link ErrorRes#ErrorRes(ResponseInfo)}
   */
  @Deprecated
  public ErrorRes() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorRes(ResponseInfo responseInfo) {
    this.responseInfo = responseInfo;
  }

  public ErrorRes responseInfo(ResponseInfo responseInfo) {
    this.responseInfo = responseInfo;
    return this;
  }

  /**
   * Get responseInfo
   * @return responseInfo
  */
  @NotNull @Valid 
  @Schema(name = "ResponseInfo", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ResponseInfo")
  public ResponseInfo getResponseInfo() {
    return responseInfo;
  }

  public void setResponseInfo(ResponseInfo responseInfo) {
    this.responseInfo = responseInfo;
  }

  public ErrorRes errors(List<@Valid Error> errors) {
    this.errors = errors;
    return this;
  }

  public ErrorRes addErrorsItem(Error errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Error response array corresponding to Request Object array. In case of single object submission or _search related paths this may be an array of one error element
   * @return errors
  */
  @Valid 
  @Schema(name = "Errors", description = "Error response array corresponding to Request Object array. In case of single object submission or _search related paths this may be an array of one error element", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("Errors")
  public List<@Valid Error> getErrors() {
    return errors;
  }

  public void setErrors(List<@Valid Error> errors) {
    this.errors = errors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorRes errorRes = (ErrorRes) o;
    return Objects.equals(this.responseInfo, errorRes.responseInfo) &&
        Objects.equals(this.errors, errorRes.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseInfo, errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorRes {\n");
    sb.append("    responseInfo: ").append(toIndentedString(responseInfo)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

