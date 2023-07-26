package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
import com.egov.servicerequest.model.Role;
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
 * User role carries the tenant related role information for the user. A user can have multiple roles per tenant based on the need of the tenant. A user may also have multiple roles for multiple tenants.
 */

@Schema(name = "TenantRole", description = "User role carries the tenant related role information for the user. A user can have multiple roles per tenant based on the need of the tenant. A user may also have multiple roles for multiple tenants.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class TenantRole {

  private String tenantId;

  @Valid
  private List<@Valid Role> roles = new ArrayList<>();

  /**
   * Default constructor
   * @deprecated Use {@link TenantRole#TenantRole(String, List<@Valid Role>)}
   */
  @Deprecated
  public TenantRole() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TenantRole(String tenantId, List<@Valid Role> roles) {
    this.tenantId = tenantId;
    this.roles = roles;
  }

  public TenantRole tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  /**
   * tenantid for the tenant
   * @return tenantId
  */
  @NotNull 
  @Schema(name = "tenantId", description = "tenantid for the tenant", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tenantId")
  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public TenantRole roles(List<@Valid Role> roles) {
    this.roles = roles;
    return this;
  }

  public TenantRole addRolesItem(Role rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

  /**
   * Roles assigned for a particular tenant - array of role codes/names
   * @return roles
  */
  @NotNull @Valid 
  @Schema(name = "roles", description = "Roles assigned for a particular tenant - array of role codes/names", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("roles")
  public List<@Valid Role> getRoles() {
    return roles;
  }

  public void setRoles(List<@Valid Role> roles) {
    this.roles = roles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TenantRole tenantRole = (TenantRole) o;
    return Objects.equals(this.tenantId, tenantRole.tenantId) &&
        Objects.equals(this.roles, tenantRole.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, roles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TenantRole {\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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

