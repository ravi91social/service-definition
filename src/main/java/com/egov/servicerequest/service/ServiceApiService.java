package com.egov.servicerequest.service;

import com.egov.servicerequest.controller.ServiceApiDelegate;
import com.egov.servicerequest.dao.ServiceDAO;
import com.egov.servicerequest.dao.ServiceDefinitionDAO;
import com.egov.servicerequest.exceptions.NoRecordFoundException;
import com.egov.servicerequest.model.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@Service
public class ServiceApiService implements ServiceApiDelegate {
    Logger logger = LoggerFactory.getLogger(ServiceApiService.class);

    private ServiceDAO serviceDAO;
    private ServiceDefinitionDAO serviceDefinitionDAO;

    @Autowired
    public ServiceApiService(ServiceDAO serviceDAO, ServiceDefinitionDAO serviceDefinitionDAO) {
        this.serviceDAO = serviceDAO;
        this.serviceDefinitionDAO = serviceDefinitionDAO;
    }

    public ServiceDefinitionResponse saveServiceDefinition(ServiceDefinitionRequest serviceDefinitionRequest)  {
        RequestInfo requestInfo = serviceDefinitionRequest.getRequestInfo();
        ResponseInfo responseInfo = getResponseInfo(requestInfo);

        ServiceDefinitionResponse response = new ServiceDefinitionResponse();
        response.setResponseInfo(responseInfo);
        ServiceDefinition serviceDefinition = serviceDefinitionRequest.getServiceDefinition();

        logger.info("getting additional data for service definition");
        String url = "https://random-data-api.com/api/v2/users?size=1";
        String dataResponse = null;
        dataResponse = getDataFromUrl(url);
        JsonObject convertedObject = new Gson().fromJson(dataResponse, JsonObject.class);
        JsonObject addressObject = new JsonObject();
        if(convertedObject != null && convertedObject.getAsJsonObject("address") != null) {
            addressObject.add("address", convertedObject.getAsJsonObject("address"));
        }
        logger.info("fetched address from additional data");
        serviceDefinition.setAdditionalDetails(addressObject);
        serviceDefinitionDAO.save(serviceDefinition);
        response.addServiceDefinitionItem(serviceDefinition);
        return response;
    }

    public ServiceResponse saveService(ServiceRequest serviceRequest) {
        RequestInfo requestInfo = serviceRequest.getRequestInfo();
        ResponseInfo responseInfo = getResponseInfo(requestInfo);

        ServiceResponse response = new ServiceResponse();
        response.setResponseInfo(responseInfo);
        com.egov.servicerequest.model.Service service = serviceRequest.getService();
        String url = "https://random-data-api.com/api/v2/users?size=1";
        String dataResponse = null;
        dataResponse = getDataFromUrl(url);
        JsonObject convertedObject = new Gson().fromJson(dataResponse, JsonObject.class);
        JsonObject addressObject = new JsonObject();
        if(convertedObject != null && convertedObject.getAsJsonObject("address") != null) {
            addressObject.add("address", convertedObject.getAsJsonObject("address"));
        }
        service.setAdditionalDetails(addressObject);
        serviceDAO.save(service);
        response.addServiceItem(service);
        return response;
    }

    /**
     * use okHttpClient to get data from url
     *
     * @param url
     * @return
     */
    public String getDataFromUrl(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };
        String responseBody = null;
        try {
            responseBody =  httpclient.execute(httpget, responseHandler);
        }catch (IOException exception) {
           exception.printStackTrace();
        }
        return responseBody;
    }

    public ResponseInfo getResponseInfo(@NotNull RequestInfo requestInfo) {
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setApiId(requestInfo.getApiId());
        responseInfo.setVer(requestInfo.getVer());
        responseInfo.setTs(requestInfo.getTs());
        responseInfo.setMsgId(requestInfo.getMsgId());
        return responseInfo;
    }

    @Override
    public ResponseEntity<ServiceDefinitionResponse> serviceDefinitionV1SearchPost(ServiceDefinitionSearchRequest serviceDefinitionSearchRequest) {
        ServiceDefinitionResponse serviceDefinitionResponse = new ServiceDefinitionResponse();
        serviceDefinitionResponse.setPagination(serviceDefinitionSearchRequest.getPagination());
        serviceDefinitionResponse.setResponseInfo(getResponseInfo(serviceDefinitionSearchRequest.getRequestInfo()));
        ServiceDefinitionCriteria serviceDefinitionCriteria = serviceDefinitionSearchRequest.getServiceDefinitionCriteria();
        List<ServiceDefinition> searchResult = serviceDefinitionDAO.findByServiceDefinitionCriteria(serviceDefinitionCriteria, serviceDefinitionSearchRequest.getPagination());
        if(searchResult == null || searchResult.size() == 0) {
            throw new NoRecordFoundException("zero records fetched for service Definition");
        }
        if(searchResult != null) searchResult.forEach(serviceDefinition -> serviceDefinitionResponse.addServiceDefinitionItem(serviceDefinition));
        return new ResponseEntity<>(serviceDefinitionResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ServiceResponse> serviceV1SearchPost(ServiceSearchRequest serviceSearchRequest) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setPagination(serviceSearchRequest.getPagination());
        serviceResponse.setResponseInfo(getResponseInfo(serviceSearchRequest.getRequestInfo()));
        ServiceCriteria serviceCriteria = serviceSearchRequest.getServiceDefinition();
        List<com.egov.servicerequest.model.Service> searchResult = serviceDAO.findByServiceCriteria(serviceCriteria, serviceSearchRequest.getPagination());
        if(searchResult != null) searchResult.forEach(service -> serviceResponse.addServiceItem(service));
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
