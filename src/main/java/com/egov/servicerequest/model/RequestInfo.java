package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.UserInfo;
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
 * RequestInfo should be used to carry meta information about the requests to the server as described in the fields below. All eGov APIs will use requestinfo as a part of the request body to carry this meta information. Some of this information will be returned back from the server as part of the ResponseInfo in the response body to ensure correlation.
 */

@Schema(name = "RequestInfo", description = "RequestInfo should be used to carry meta information about the requests to the server as described in the fields below. All eGov APIs will use requestinfo as a part of the request body to carry this meta information. Some of this information will be returned back from the server as part of the ResponseInfo in the response body to ensure correlation.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class RequestInfo {

  private String apiId;

  private String ver;

  private Long ts;

  private String action;

  private String did;

  private String key;

  private String msgId;

  private String requesterId;

  private String authToken;

  private UserInfo userInfo;

  private String correlationId;

  /**
   * Default constructor
   * @deprecated Use {@link RequestInfo#RequestInfo(String, String, Long, String, String)}
   */
  @Deprecated
  public RequestInfo() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RequestInfo(String apiId, String ver, Long ts, String action, String msgId) {
    this.apiId = apiId;
    this.ver = ver;
    this.ts = ts;
    this.action = action;
    this.msgId = msgId;
  }

  public RequestInfo apiId(String apiId) {
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

  public RequestInfo ver(String ver) {
    this.ver = ver;
    return this;
  }

  /**
   * API version - for HTTP based request this will be same as used in path
   * @return ver
  */
  @NotNull @Size(max = 32) 
  @Schema(name = "ver", description = "API version - for HTTP based request this will be same as used in path", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ver")
  public String getVer() {
    return ver;
  }

  public void setVer(String ver) {
    this.ver = ver;
  }

  public RequestInfo ts(Long ts) {
    this.ts = ts;
    return this;
  }

  /**
   * time in epoch
   * @return ts
  */
  @NotNull 
  @Schema(name = "ts", description = "time in epoch", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ts")
  public Long getTs() {
    return ts;
  }

  public void setTs(Long ts) {
    this.ts = ts;
  }

  public RequestInfo action(String action) {
    this.action = action;
    return this;
  }

  /**
   * API action to be performed like _create, _update, _search (denoting POST, PUT, GET) or _oauth etc
   * @return action
  */
  @NotNull @Size(max = 32) 
  @Schema(name = "action", description = "API action to be performed like _create, _update, _search (denoting POST, PUT, GET) or _oauth etc", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("action")
  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public RequestInfo did(String did) {
    this.did = did;
    return this;
  }

  /**
   * Device ID from which the API is called
   * @return did
  */
  @Size(max = 1024) 
  @Schema(name = "did", description = "Device ID from which the API is called", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("did")
  public String getDid() {
    return did;
  }

  public void setDid(String did) {
    this.did = did;
  }

  public RequestInfo key(String key) {
    this.key = key;
    return this;
  }

  /**
   * API key (API key provided to the caller in case of server to server communication)
   * @return key
  */
  @Size(max = 256) 
  @Schema(name = "key", description = "API key (API key provided to the caller in case of server to server communication)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("key")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public RequestInfo msgId(String msgId) {
    this.msgId = msgId;
    return this;
  }

  /**
   * Unique request message id from the caller
   * @return msgId
  */
  @NotNull @Size(max = 256) 
  @Schema(name = "msgId", description = "Unique request message id from the caller", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("msgId")
  public String getMsgId() {
    return msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }

  public RequestInfo requesterId(String requesterId) {
    this.requesterId = requesterId;
    return this;
  }

  /**
   * UserId of the user calling
   * @return requesterId
  */
  @Size(max = 256) 
  @Schema(name = "requesterId", description = "UserId of the user calling", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requesterId")
  public String getRequesterId() {
    return requesterId;
  }

  public void setRequesterId(String requesterId) {
    this.requesterId = requesterId;
  }

  public RequestInfo authToken(String authToken) {
    this.authToken = authToken;
    return this;
  }

  /**
   * //session/jwt/saml token/oauth token - the usual value that would go into HTTP bearer token
   * @return authToken
  */
  
  @Schema(name = "authToken", description = "//session/jwt/saml token/oauth token - the usual value that would go into HTTP bearer token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("authToken")
  public String getAuthToken() {
    return authToken;
  }

  public void setAuthToken(String authToken) {
    this.authToken = authToken;
  }

  public RequestInfo userInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
    return this;
  }

  /**
   * Get userInfo
   * @return userInfo
  */
  @Valid 
  @Schema(name = "userInfo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userInfo")
  public UserInfo getUserInfo() {
    return userInfo;
  }

  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  public RequestInfo correlationId(String correlationId) {
    this.correlationId = correlationId;
    return this;
  }

  /**
   * Get correlationId
   * @return correlationId
  */
  
  @Schema(name = "correlationId", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("correlationId")
  public String getCorrelationId() {
    return correlationId;
  }

  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestInfo requestInfo = (RequestInfo) o;
    return Objects.equals(this.apiId, requestInfo.apiId) &&
        Objects.equals(this.ver, requestInfo.ver) &&
        Objects.equals(this.ts, requestInfo.ts) &&
        Objects.equals(this.action, requestInfo.action) &&
        Objects.equals(this.did, requestInfo.did) &&
        Objects.equals(this.key, requestInfo.key) &&
        Objects.equals(this.msgId, requestInfo.msgId) &&
        Objects.equals(this.requesterId, requestInfo.requesterId) &&
        Objects.equals(this.authToken, requestInfo.authToken) &&
        Objects.equals(this.userInfo, requestInfo.userInfo) &&
        Objects.equals(this.correlationId, requestInfo.correlationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiId, ver, ts, action, did, key, msgId, requesterId, authToken, userInfo, correlationId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestInfo {\n");
    sb.append("    apiId: ").append(toIndentedString(apiId)).append("\n");
    sb.append("    ver: ").append(toIndentedString(ver)).append("\n");
    sb.append("    ts: ").append(toIndentedString(ts)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    did: ").append(toIndentedString(did)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    msgId: ").append(toIndentedString(msgId)).append("\n");
    sb.append("    requesterId: ").append(toIndentedString(requesterId)).append("\n");
    sb.append("    authToken: ").append(toIndentedString(authToken)).append("\n");
    sb.append("    userInfo: ").append(toIndentedString(userInfo)).append("\n");
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
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

