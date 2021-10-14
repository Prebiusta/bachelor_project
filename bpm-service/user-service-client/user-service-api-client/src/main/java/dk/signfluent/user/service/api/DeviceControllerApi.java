package dk.signfluent.user.service.api;

import dk.signfluent.user.service.invoker.ApiClient;

import dk.signfluent.user.service.model.RegisterDeviceRequest;
import dk.signfluent.user.service.model.RegisterDeviceResponse;
import dk.signfluent.user.service.model.UpdateFCMTokenRequest;
import dk.signfluent.user.service.model.UpdateFCMTokenResponse;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-10-14T14:41:50.888430+02:00[Europe/Copenhagen]")
@Component("dk.signfluent.user.service.api.DeviceControllerApi")
public class DeviceControllerApi {
    private ApiClient apiClient;

    public DeviceControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public DeviceControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Register Device
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param registerDeviceRequest registerDeviceRequest (required)
     * @return RegisterDeviceResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RegisterDeviceResponse registerDevice(RegisterDeviceRequest registerDeviceRequest) throws RestClientException {
        return registerDeviceWithHttpInfo(registerDeviceRequest).getBody();
    }

    /**
     * Register Device
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param registerDeviceRequest registerDeviceRequest (required)
     * @return ResponseEntity&lt;RegisterDeviceResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<RegisterDeviceResponse> registerDeviceWithHttpInfo(RegisterDeviceRequest registerDeviceRequest) throws RestClientException {
        Object postBody = registerDeviceRequest;
        
        // verify the required parameter 'registerDeviceRequest' is set
        if (registerDeviceRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'registerDeviceRequest' when calling registerDevice");
        }
        
        String path = apiClient.expandPath("/api/deviceManagement/registerDevice", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<RegisterDeviceResponse> returnType = new ParameterizedTypeReference<RegisterDeviceResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, contentType, authNames, returnType);
    }
    /**
     * Update FCM Token
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param updateFCMTokenRequest updateFCMTokenRequest (required)
     * @return UpdateFCMTokenResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UpdateFCMTokenResponse updateFCMToken(UpdateFCMTokenRequest updateFCMTokenRequest) throws RestClientException {
        return updateFCMTokenWithHttpInfo(updateFCMTokenRequest).getBody();
    }

    /**
     * Update FCM Token
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param updateFCMTokenRequest updateFCMTokenRequest (required)
     * @return ResponseEntity&lt;UpdateFCMTokenResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UpdateFCMTokenResponse> updateFCMTokenWithHttpInfo(UpdateFCMTokenRequest updateFCMTokenRequest) throws RestClientException {
        Object postBody = updateFCMTokenRequest;
        
        // verify the required parameter 'updateFCMTokenRequest' is set
        if (updateFCMTokenRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'updateFCMTokenRequest' when calling updateFCMToken");
        }
        
        String path = apiClient.expandPath("/api/deviceManagement/updateFCMToken", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<UpdateFCMTokenResponse> returnType = new ParameterizedTypeReference<UpdateFCMTokenResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, contentType, authNames, returnType);
    }
}
