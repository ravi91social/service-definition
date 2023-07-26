package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ResponseInfo should be used to carry metadata information about the response from the server. apiId, ver and msgId in ResponseInfo should always correspond to the same values in respective request&#39;s RequestInfo.
 */

@Schema(name = "ResponseInfo", description = "ResponseInfo should be used to carry metadata information about the response from the server. apiId, ver and msgId in ResponseInfo should always correspond to the same values in respective request's RequestInfo.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class ResponseInfo {

  private String apiId;

  private String ver;

  private Long ts;

  private String resMsgId;

  private String msgId;

  /**
   * status of request processing - to be enhanced in futuer to include INPROGRESS
   */
  public enum StatusEnum {
    SUCCESSFUL("SUCCESSFUL"),
    
    FAILED("FAILED");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  /**
   * Default constructor
   * @deprecated Use {@link ResponseInfo#ResponseInfo(String, String, Long, StatusEnum)}
   */
  @Deprecated
  public ResponseInfo() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ResponseInfo(String apiId, String ver, Long ts, StatusEnum status) {
    this.apiId = apiId;
    this.ver = ver;
    this.ts = ts;
    this.status = status;
  }

  public ResponseInfo apiId(String apiId) {
    this.apiId = apiId;
    return this;
  }

  /**
   * unique API ID
   * @return apiId
  */
  @NotNull @Size(max = 128) 
  @Schema(name = "apiId", description = "unique API ID", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("apiId")
  public String getApiId() {
    return apiId;
  }

  public void setApiId(String apiId) {
    this.apiId = apiId;
  }

  public ResponseInfo ver(String ver) {
    this.ver = ver;
    return this;
  }

  /**
   * API version
   * @return ver
  */
  @NotNull @Size(max = 32) 
  @Schema(name = "ver", description = "API version", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ver")
  public String getVer() {
    return ver;
  }

  public void setVer(String ver) {
    this.ver = ver;
  }

  public ResponseInfo ts(Long ts) {
    this.ts = ts;
    return this;
  }

  /**
   * response time in epoch
   * @return ts
  */
  @NotNull 
  @Schema(name = "ts", description = "response time in epoch", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ts")
  public Long getTs() {
    return ts;
  }

  public void setTs(Long ts) {
    this.ts = ts;
  }

  public ResponseInfo resMsgId(String resMsgId) {
    this.resMsgId = resMsgId;
    return this;
  }

  /**
   * unique response message id (UUID) - will usually be the correlation id from the server
   * @return resMsgId
  */
  @Size(max = 256) 
  @Schema(name = "resMsgId", description = "unique response message id (UUID) - will usually be the correlation id from the server", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resMsgId")
  public String getResMsgId() {
    return resMsgId;
  }

  public void setResMsgId(String resMsgId) {
    this.resMsgId = resMsgId;
  }

  public ResponseInfo msgId(String msgId) {
    this.msgId = msgId;
    return this;
  }

  /**
   * message id of the request
   * @return msgId
  */
  @Size(max = 256) 
  @Schema(name = "msgId", description = "message id of the request", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("msgId")
  public String getMsgId() {
    return msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }

  public ResponseInfo status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * status of request processing - to be enhanced in futuer to include INPROGRESS
   * @return status
  */
  @NotNull 
  @Schema(name = "status", description = "status of request processing - to be enhanced in futuer to include INPROGRESS", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseInfo responseInfo = (ResponseInfo) o;
    return Objects.equals(this.apiId, responseInfo.apiId) &&
        Objects.equals(this.ver, responseInfo.ver) &&
        Objects.equals(this.ts, responseInfo.ts) &&
        Objects.equals(this.resMsgId, responseInfo.resMsgId) &&
        Objects.equals(this.msgId, responseInfo.msgId) &&
        Objects.equals(this.status, responseInfo.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiId, ver, ts, resMsgId, msgId, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseInfo {\n");
    sb.append("    apiId: ").append(toIndentedString(apiId)).append("\n");
    sb.append("    ver: ").append(toIndentedString(ver)).append("\n");
    sb.append("    ts: ").append(toIndentedString(ts)).append("\n");
    sb.append("    resMsgId: ").append(toIndentedString(resMsgId)).append("\n");
    sb.append("    msgId: ").append(toIndentedString(msgId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

