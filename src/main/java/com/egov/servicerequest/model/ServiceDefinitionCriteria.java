package com.egov.servicerequest.model;

import java.net.URI;
import java.util.Objects;
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
 * The object will contain all the search parameters for Service Definition.
 */

@Schema(name = "ServiceDefinitionCriteria", description = "The object will contain all the search parameters for Service Definition.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public class ServiceDefinitionCriteria {

  private String tenantId;

  @Valid
  private List<String> ids;

  @Valid
  private List<String> code;

  private String clientId;

  /**
   * Default constructor
   * @deprecated Use {@link ServiceDefinitionCriteria#ServiceDefinitionCriteria(String)}
   */
  @Deprecated
  public ServiceDefinitionCriteria() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ServiceDefinitionCriteria(String tenantId) {
    this.tenantId = tenantId;
  }

  public ServiceDefinitionCriteria tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  /**
   * Tenant Identifier
   * @return tenantId
  */
  @NotNull @Size(min = 2, max = 64) 
  @Schema(name = "tenantId", example = "pb.amritsar", description = "Tenant Identifier", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tenantId")
  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public ServiceDefinitionCriteria ids(List<String> ids) {
    this.ids = ids;
    return this;
  }

  public ServiceDefinitionCriteria addIdsItem(String idsItem) {
    if (this.ids == null) {
      this.ids = new ArrayList<>();
    }
    this.ids.add(idsItem);
    return this;
  }

  /**
   * Search by service definition ids
   * @return ids
  */
  
  @Schema(name = "ids", description = "Search by service definition ids", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ids")
  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }

  public ServiceDefinitionCriteria code(List<String> code) {
    this.code = code;
    return this;
  }

  public ServiceDefinitionCriteria addCodeItem(String codeItem) {
    if (this.code == null) {
      this.code = new ArrayList<>();
    }
    this.code.add(codeItem);
    return this;
  }

  /**
   * Search by service definition code
   * @return code
  */
  
  @Schema(name = "code", description = "Search by service definition code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public List<String> getCode() {
    return code;
  }

  public void setCode(List<String> code) {
    this.code = code;
  }

  public ServiceDefinitionCriteria clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * Client Id
   * @return clientId
  */
  @Size(min = 2, max = 64) 
  @Schema(name = "clientId", description = "Client Id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clientId")
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceDefinitionCriteria serviceDefinitionCriteria = (ServiceDefinitionCriteria) o;
    return Objects.equals(this.tenantId, serviceDefinitionCriteria.tenantId) &&
        Objects.equals(this.ids, serviceDefinitionCriteria.ids) &&
        Objects.equals(this.code, serviceDefinitionCriteria.code) &&
        Objects.equals(this.clientId, serviceDefinitionCriteria.clientId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, ids, code, clientId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceDefinitionCriteria {\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
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

