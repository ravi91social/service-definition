package com.egov.servicerequest.controller;

import com.egov.servicerequest.model.ErrorRes;
import com.egov.servicerequest.model.ServiceDefinitionRequest;
import com.egov.servicerequest.model.ServiceDefinitionResponse;
import com.egov.servicerequest.model.ServiceDefinitionSearchRequest;
import com.egov.servicerequest.model.ServiceRequest;
import com.egov.servicerequest.model.ServiceResponse;
import com.egov.servicerequest.model.ServiceSearchRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link ServiceApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
public interface ServiceApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /service/definition/v1/_create
     *
     * @param serviceDefinitionRequest  (optional)
     * @return Request accepted. (status code 202)
     *         or Invalid input. (status code 400)
     * @see ServiceApi#serviceDefinitionV1CreatePost
     */
    default ResponseEntity<ServiceDefinitionResponse> serviceDefinitionV1CreatePost(ServiceDefinitionRequest serviceDefinitionRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("*/*"))) {
                    String exampleString = "{ \"pagination\" : { \"offSet\" : 5.637376656633329, \"limit\" : 59.621339166831824, \"sortBy\" : \"sortBy\", \"totalCount\" : 2.3021358869347655, \"order\" : \"asc\" }, \"serviceDefinition\" : [ { \"code\" : \"code\", \"clientId\" : \"clientId\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"attributes\" : [ { \"regEx\" : \"regEx\", \"code\" : \"code\", \"dataType\" : \"String\", \"values\" : [ \"values\", \"values\" ], \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"id\" : \"id\", \"isActive\" : true, \"additionalDetails\" : \"{}\", \"required\" : true, \"order\" : \"order\" }, { \"regEx\" : \"regEx\", \"code\" : \"code\", \"dataType\" : \"String\", \"values\" : [ \"values\", \"values\" ], \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"id\" : \"id\", \"isActive\" : true, \"additionalDetails\" : \"{}\", \"required\" : true, \"order\" : \"order\" } ], \"id\" : \"id\", \"isActive\" : true, \"additionalDetails\" : \"{}\" }, { \"code\" : \"code\", \"clientId\" : \"clientId\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"attributes\" : [ { \"regEx\" : \"regEx\", \"code\" : \"code\", \"dataType\" : \"String\", \"values\" : [ \"values\", \"values\" ], \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"id\" : \"id\", \"isActive\" : true, \"additionalDetails\" : \"{}\", \"required\" : true, \"order\" : \"order\" }, { \"regEx\" : \"regEx\", \"code\" : \"code\", \"dataType\" : \"String\", \"values\" : [ \"values\", \"values\" ], \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"id\" : \"id\", \"isActive\" : true, \"additionalDetails\" : \"{}\", \"required\" : true, \"order\" : \"order\" } ], \"id\" : \"id\", \"isActive\" : true, \"additionalDetails\" : \"{}\" } ], \"responseInfo\" : { \"ver\" : \"ver\", \"resMsgId\" : \"resMsgId\", \"msgId\" : \"msgId\", \"apiId\" : \"apiId\", \"ts\" : 0, \"status\" : \"SUCCESSFUL\" } }";
                    ApiUtil.setExampleResponse(request, "*/*", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /service/definition/v1/_search
     *
     * @param serviceDefinitionSearchRequest  (optional)
     * @return Request accepted. (status code 202)
     *         or Invalid input. (status code 400)
     * @see ServiceApi#serviceDefinitionV1SearchPost
     */
    default ResponseEntity<ServiceDefinitionResponse> serviceDefinitionV1SearchPost(ServiceDefinitionSearchRequest serviceDefinitionSearchRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("*/*"))) {
                    String exampleString = "{ \"pagination\" : { \"offSet\" : 5.637376656633329, \"limit\" : 59.621339166831824, \"sortBy\" : \"sortBy\", \"totalCount\" : 2.3021358869347655, \"order\" : \"asc\" }, \"serviceDefinition\" : [ { \"code\" : \"code\", \"clientId\" : \"clientId\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"attributes\" : [ { \"regEx\" : \"regEx\", \"code\" : \"code\", \"dataType\" : \"String\", \"values\" : [ \"values\", \"values\" ], \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"id\" : \"id\", \"isActive\" : true, \"additionalDetails\" : \"{}\", \"required\" : true, \"order\" : \"order\" }, { \"regEx\" : \"regEx\", \"code\" : \"code\", \"dataType\" : \"String\", \"values\" : [ \"values\", \"values\" ], \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"id\" : \"id\", \"isActive\" : true, \"additionalDetails\" : \"{}\", \"required\" : true, \"order\" : \"order\" } ], \"id\" : \"id\", \"isActive\" : true, \"additionalDetails\" : \"{}\" }, { \"code\" : \"code\", \"clientId\" : \"clientId\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"attributes\" : [ { \"regEx\" : \"regEx\", \"code\" : \"code\", \"dataType\" : \"String\", \"values\" : [ \"values\", \"values\" ], \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"id\" : \"id\", \"isActive\" : true, \"additionalDetails\" : \"{}\", \"required\" : true, \"order\" : \"order\" }, { \"regEx\" : \"regEx\", \"code\" : \"code\", \"dataType\" : \"String\", \"values\" : [ \"values\", \"values\" ], \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"id\" : \"id\", \"isActive\" : true, \"additionalDetails\" : \"{}\", \"required\" : true, \"order\" : \"order\" } ], \"id\" : \"id\", \"isActive\" : true, \"additionalDetails\" : \"{}\" } ], \"responseInfo\" : { \"ver\" : \"ver\", \"resMsgId\" : \"resMsgId\", \"msgId\" : \"msgId\", \"apiId\" : \"apiId\", \"ts\" : 0, \"status\" : \"SUCCESSFUL\" } }";
                    ApiUtil.setExampleResponse(request, "*/*", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /service/v1/_create
     *
     * @param serviceRequest  (optional)
     * @return Request accepted. (status code 202)
     *         or Invalid input. (status code 400)
     * @see ServiceApi#serviceV1CreatePost
     */
    default ResponseEntity<ServiceResponse> serviceV1CreatePost(ServiceRequest serviceRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("*/*"))) {
                    String exampleString = "{ \"pagination\" : { \"offSet\" : 5.637376656633329, \"limit\" : 59.621339166831824, \"sortBy\" : \"sortBy\", \"totalCount\" : 2.3021358869347655, \"order\" : \"asc\" }, \"service\" : [ { \"accountId\" : \"accountId\", \"clientId\" : \"clientId\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"serviceDefId\" : \"serviceDefId\", \"attributes\" : [ { \"attributeCode\" : \"attributeCode\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"id\" : \"id\", \"additionalDetails\" : \"{}\", \"value\" : \"{}\" }, { \"attributeCode\" : \"attributeCode\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"id\" : \"id\", \"additionalDetails\" : \"{}\", \"value\" : \"{}\" } ], \"id\" : \"id\", \"additionalDetails\" : \"{}\", \"referenceId\" : \"referenceId\" }, { \"accountId\" : \"accountId\", \"clientId\" : \"clientId\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"serviceDefId\" : \"serviceDefId\", \"attributes\" : [ { \"attributeCode\" : \"attributeCode\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"id\" : \"id\", \"additionalDetails\" : \"{}\", \"value\" : \"{}\" }, { \"attributeCode\" : \"attributeCode\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"id\" : \"id\", \"additionalDetails\" : \"{}\", \"value\" : \"{}\" } ], \"id\" : \"id\", \"additionalDetails\" : \"{}\", \"referenceId\" : \"referenceId\" } ], \"responseInfo\" : { \"ver\" : \"ver\", \"resMsgId\" : \"resMsgId\", \"msgId\" : \"msgId\", \"apiId\" : \"apiId\", \"ts\" : 0, \"status\" : \"SUCCESSFUL\" } }";
                    ApiUtil.setExampleResponse(request, "*/*", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /service/v1/_search
     *
     * @param serviceSearchRequest  (optional)
     * @return Request accepted. (status code 202)
     *         or Invalid input. (status code 400)
     * @see ServiceApi#serviceV1SearchPost
     */
    default ResponseEntity<ServiceResponse> serviceV1SearchPost(ServiceSearchRequest serviceSearchRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("*/*"))) {
                    String exampleString = "{ \"pagination\" : { \"offSet\" : 5.637376656633329, \"limit\" : 59.621339166831824, \"sortBy\" : \"sortBy\", \"totalCount\" : 2.3021358869347655, \"order\" : \"asc\" }, \"service\" : [ { \"accountId\" : \"accountId\", \"clientId\" : \"clientId\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"serviceDefId\" : \"serviceDefId\", \"attributes\" : [ { \"attributeCode\" : \"attributeCode\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"id\" : \"id\", \"additionalDetails\" : \"{}\", \"value\" : \"{}\" }, { \"attributeCode\" : \"attributeCode\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"id\" : \"id\", \"additionalDetails\" : \"{}\", \"value\" : \"{}\" } ], \"id\" : \"id\", \"additionalDetails\" : \"{}\", \"referenceId\" : \"referenceId\" }, { \"accountId\" : \"accountId\", \"clientId\" : \"clientId\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"tenantId\" : \"pb.amritsar\", \"serviceDefId\" : \"serviceDefId\", \"attributes\" : [ { \"attributeCode\" : \"attributeCode\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"id\" : \"id\", \"additionalDetails\" : \"{}\", \"value\" : \"{}\" }, { \"attributeCode\" : \"attributeCode\", \"auditDetails\" : { \"lastModifiedTime\" : 1, \"createdBy\" : \"createdBy\", \"lastModifiedBy\" : \"lastModifiedBy\", \"createdTime\" : 6 }, \"id\" : \"id\", \"additionalDetails\" : \"{}\", \"value\" : \"{}\" } ], \"id\" : \"id\", \"additionalDetails\" : \"{}\", \"referenceId\" : \"referenceId\" } ], \"responseInfo\" : { \"ver\" : \"ver\", \"resMsgId\" : \"resMsgId\", \"msgId\" : \"msgId\", \"apiId\" : \"apiId\", \"ts\" : 0, \"status\" : \"SUCCESSFUL\" } }";
                    ApiUtil.setExampleResponse(request, "*/*", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
