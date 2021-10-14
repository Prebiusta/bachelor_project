# DeviceControllerApi

All URIs are relative to *http://localhost:8003*

Method | HTTP request | Description
------------- | ------------- | -------------
[**registerDevice**](DeviceControllerApi.md#registerDevice) | **POST** /api/deviceManagement/registerDevice | Register Device
[**updateFCMToken**](DeviceControllerApi.md#updateFCMToken) | **POST** /api/deviceManagement/updateFCMToken | Update FCM Token


<a name="registerDevice"></a>
# **registerDevice**
> RegisterDeviceResponse registerDevice(registerDeviceRequest)

Register Device

### Example
```java
// Import classes:
import dk.signfluent.user.service.invoker.ApiClient;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.invoker.Configuration;
import dk.signfluent.user.service.invoker.models.*;
import dk.signfluent.user.service.api.DeviceControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8003");

    DeviceControllerApi apiInstance = new DeviceControllerApi(defaultClient);
    RegisterDeviceRequest registerDeviceRequest = new RegisterDeviceRequest(); // RegisterDeviceRequest | registerDeviceRequest
    try {
      RegisterDeviceResponse result = apiInstance.registerDevice(registerDeviceRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DeviceControllerApi#registerDevice");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **registerDeviceRequest** | [**RegisterDeviceRequest**](RegisterDeviceRequest.md)| registerDeviceRequest |

### Return type

[**RegisterDeviceResponse**](RegisterDeviceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="updateFCMToken"></a>
# **updateFCMToken**
> UpdateFCMTokenResponse updateFCMToken(updateFCMTokenRequest)

Update FCM Token

### Example
```java
// Import classes:
import dk.signfluent.user.service.invoker.ApiClient;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.invoker.Configuration;
import dk.signfluent.user.service.invoker.models.*;
import dk.signfluent.user.service.api.DeviceControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8003");

    DeviceControllerApi apiInstance = new DeviceControllerApi(defaultClient);
    UpdateFCMTokenRequest updateFCMTokenRequest = new UpdateFCMTokenRequest(); // UpdateFCMTokenRequest | updateFCMTokenRequest
    try {
      UpdateFCMTokenResponse result = apiInstance.updateFCMToken(updateFCMTokenRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DeviceControllerApi#updateFCMToken");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateFCMTokenRequest** | [**UpdateFCMTokenRequest**](UpdateFCMTokenRequest.md)| updateFCMTokenRequest |

### Return type

[**UpdateFCMTokenResponse**](UpdateFCMTokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

