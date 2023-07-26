package com.egov.servicerequest.controller;

import com.egov.servicerequest.exceptions.NoRecordFoundException;
import com.egov.servicerequest.model.*;
import com.egov.servicerequest.service.ServiceApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Generated;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-24T14:37:48.733516900+05:30[Asia/Calcutta]")
@Controller
public class ServiceApiController implements ServiceApi {

    Logger logger = LoggerFactory.getLogger(ServiceApiController.class);
    @Autowired
    private ServiceApiService serviceApiService;
    private final ServiceApiDelegate delegate;

    public ServiceApiController(@Autowired(required = false) ServiceApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ServiceApiDelegate() {});
    }

    @Override
    public ServiceApiDelegate getDelegate() {
        return delegate;
    }

    /**
     * POST /service/definition/v1/_create
     *
     * @param serviceDefinitionRequest  (optional)
     * @return Request accepted. (status code 202)
     *         or Invalid input. (status code 400)
     */
    @Operation(
            operationId = "serviceDefinitionV1CreatePost",
            tags = { "Service Definition" },
            responses = {
                    @ApiResponse(responseCode = "202", description = "Request accepted.", content = {
                            @Content(mediaType = "*/*", schema = @Schema(implementation = ServiceDefinitionResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid input.", content = {
                            @Content(mediaType = "*/*", schema = @Schema(implementation = ErrorRes.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/service/definition/v1/_create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = { "application/json" }
    )
    @Override
    public ResponseEntity<ServiceDefinitionResponse> serviceDefinitionV1CreatePost(ServiceDefinitionRequest serviceDefinitionRequest) {
        logger.info("create service definition controller accessed.");
        serviceApiService.saveServiceDefinition(serviceDefinitionRequest);
        return new ResponseEntity<>(new ServiceDefinitionResponse(), HttpStatus.OK);
    }

    /**
     * POST /service/definition/v1/_search
     *
     * @param serviceDefinitionSearchRequest  (optional)
     * @return Request accepted. (status code 202)
     *         or Invalid input. (status code 400)
     */
    @Operation(
            operationId = "serviceDefinitionV1SearchPost",
            tags = { "Service Definition" },
            responses = {
                    @ApiResponse(responseCode = "202", description = "Request accepted.", content = {
                            @Content(mediaType = "*/*", schema = @Schema(implementation = ServiceDefinitionResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid input.", content = {
                            @Content(mediaType = "*/*", schema = @Schema(implementation = ErrorRes.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/service/definition/v1/_search",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = { "application/json" }
    )
    @Override
    public ResponseEntity<ServiceDefinitionResponse> serviceDefinitionV1SearchPost(ServiceDefinitionSearchRequest serviceDefinitionSearchRequest) {
        logger.info("search service definition controller accessed.");
        ResponseEntity<ServiceDefinitionResponse> response = new ResponseEntity<>(HttpStatus.OK);
        try {
            response = serviceApiService.serviceDefinitionV1SearchPost(serviceDefinitionSearchRequest);
        }
        catch (NoRecordFoundException noRecordFoundException) {
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Record Not Found", noRecordFoundException);
        }
        return response;
    }

    /**
     * POST /service/v1/_create
     *
     * @param serviceRequest  (optional)
     * @return Request accepted. (status code 202)
     *         or Invalid input. (status code 400)
     */
    @Operation(
            operationId = "serviceV1CreatePost",
            tags = { "Service" },
            responses = {
                    @ApiResponse(responseCode = "202", description = "Request accepted.", content = {
                            @Content(mediaType = "*/*", schema = @Schema(implementation = ServiceResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid input.", content = {
                            @Content(mediaType = "*/*", schema = @Schema(implementation = ErrorRes.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/service/v1/_create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = { "application/json" }
    )
    @Override
    public ResponseEntity<ServiceResponse> serviceV1CreatePost(ServiceRequest serviceRequest) {
        logger.info("create service controller accessed.");
        ServiceResponse response = serviceApiService.saveService(serviceRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * POST /service/v1/_search
     *
     * @param serviceSearchRequest  (optional)
     * @return Request accepted. (status code 202)
     *         or Invalid input. (status code 400)
     */
    @Operation(
            operationId = "serviceV1SearchPost",
            tags = { "Service" },
            responses = {
                    @ApiResponse(responseCode = "202", description = "Request accepted.", content = {
                            @Content(mediaType = "*/*", schema = @Schema(implementation = ServiceResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid input.", content = {
                            @Content(mediaType = "*/*", schema = @Schema(implementation = ErrorRes.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/service/v1/_search",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = { "application/json" }
    )
    @Override
    public ResponseEntity<ServiceResponse> serviceV1SearchPost(ServiceSearchRequest serviceSearchRequest) {
        logger.info("search service controller accessed.");
        return serviceApiService.serviceV1SearchPost(serviceSearchRequest);
    }

}
