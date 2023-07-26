package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.Role;
import com.egov.servicerequest.model.TenantRole;
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
 * This is acting ID token of the authenticated user on the server. Any value provided by the clients will be ignored and actual user based on authtoken will be used on the server.
 */

@Schema(name = "UserInfo", description = "This is acting ID token of the authenticated user on the server. Any value provided by the clients will be ignored and actual user based on authtoken will be used on the server.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class UserInfo {

  private String tenantId;

  private Integer id;

  private String userName;

  private String mobile;

  private String email;

  @Valid
  private List<@Valid Role> primaryrole = new ArrayList<>();

  @Valid
  private List<@Valid TenantRole> additionalroles;

  /**
   * Default constructor
   * @deprecated Use {@link UserInfo#UserInfo(String, String, List<@Valid Role>)}
   */
  @Deprecated
  public UserInfo() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UserInfo(String tenantId, String userName, List<@Valid Role> primaryrole) {
    this.tenantId = tenantId;
    this.userName = userName;
    this.primaryrole = primaryrole;
  }

  public UserInfo tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  /**
   * Unique Identifier of the tenant to which user primarily belongs
   * @return tenantId
  */
  @NotNull 
  @Schema(name = "tenantId", description = "Unique Identifier of the tenant to which user primarily belongs", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tenantId")
  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public UserInfo id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * User id of the authenticated user. Will be deprecated in future
   * @return id
  */
  
  @Schema(name = "id", description = "User id of the authenticated user. Will be deprecated in future", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UserInfo userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Unique user name of the authenticated user
   * @return userName
  */
  @NotNull 
  @Schema(name = "userName", description = "Unique user name of the authenticated user", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userName")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserInfo mobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  /**
   * mobile number of the autheticated user
   * @return mobile
  */
  
  @Schema(name = "mobile", description = "mobile number of the autheticated user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mobile")
  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public UserInfo email(String email) {
    this.email = email;
    return this;
  }

  /**
   * email address of the authenticated user
   * @return email
  */
  
  @Schema(name = "email", description = "email address of the authenticated user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserInfo primaryrole(List<@Valid Role> primaryrole) {
    this.primaryrole = primaryrole;
    return this;
  }

  public UserInfo addPrimaryroleItem(Role primaryroleItem) {
    if (this.primaryrole == null) {
      this.primaryrole = new ArrayList<>();
    }
    this.primaryrole.add(primaryroleItem);
    return this;
  }

  /**
   * List of all the roles for the primary tenant
   * @return primaryrole
  */
  @NotNull @Valid 
  @Schema(name = "primaryrole", description = "List of all the roles for the primary tenant", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("primaryrole")
  public List<@Valid Role> getPrimaryrole() {
    return primaryrole;
  }

  public void setPrimaryrole(List<@Valid Role> primaryrole) {
    this.primaryrole = primaryrole;
  }

  public UserInfo additionalroles(List<@Valid TenantRole> additionalroles) {
    this.additionalroles = additionalroles;
    return this;
  }

  public UserInfo addAdditionalrolesItem(TenantRole additionalrolesItem) {
    if (this.additionalroles == null) {
      this.additionalroles = new ArrayList<>();
    }
    this.additionalroles.add(additionalrolesItem);
    return this;
  }

  /**
   * array of additional tenantids authorized for the authenticated user
   * @return additionalroles
  */
  @Valid 
  @Schema(name = "additionalroles", description = "array of additional tenantids authorized for the authenticated user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("additionalroles")
  public List<@Valid TenantRole> getAdditionalroles() {
    return additionalroles;
  }

  public void setAdditionalroles(List<@Valid TenantRole> additionalroles) {
    this.additionalroles = additionalroles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfo userInfo = (UserInfo) o;
    return Objects.equals(this.tenantId, userInfo.tenantId) &&
        Objects.equals(this.id, userInfo.id) &&
        Objects.equals(this.userName, userInfo.userName) &&
        Objects.equals(this.mobile, userInfo.mobile) &&
        Objects.equals(this.email, userInfo.email) &&
        Objects.equals(this.primaryrole, userInfo.primaryrole) &&
        Objects.equals(this.additionalroles, userInfo.additionalroles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, id, userName, mobile, email, primaryrole, additionalroles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfo {\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    primaryrole: ").append(toIndentedString(primaryrole)).append("\n");
    sb.append("    additionalroles: ").append(toIndentedString(additionalroles)).append("\n");
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

