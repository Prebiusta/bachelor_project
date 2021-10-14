# UserControllerApi

All URIs are relative to *http://localhost:8003*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authenticate**](UserControllerApi.md#authenticate) | **POST** /api/userManagement/authenticate | Authenticate User
[**getAvailableApprovers**](UserControllerApi.md#getAvailableApprovers) | **POST** /api/userManagement/getAvailableApprovers | Get Available Approvers
[**getDevicesForUser**](UserControllerApi.md#getDevicesForUser) | **POST** /api/userManagement/getDevicesForUser | Get Devices For User
[**getFCMTokensForUser**](UserControllerApi.md#getFCMTokensForUser) | **POST** /api/userManagement/getFCMTokensForUser | Update FCM Token



## authenticate

> AuthenticationResponse authenticate(authenticationRequest)

Authenticate User

### Example

```java
// Import classes:
import dk.signfluent.user.service.invoker.ApiClient;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.invoker.Configuration;
import dk.signfluent.user.service.invoker.models.*;
import dk.signfluent.user.service.api.UserControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8003");

        UserControllerApi apiInstance = new UserControllerApi(defaultClient);
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(); // AuthenticationRequest | authenticationRequest
        try {
            AuthenticationResponse result = apiInstance.authenticate(authenticationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserControllerApi#authenticate");
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
 **authenticationRequest** | [**AuthenticationRequest**](AuthenticationRequest.md)| authenticationRequest |

### Return type

[**AuthenticationResponse**](AuthenticationResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **201** | Created |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getAvailableApprovers

> List&lt;User&gt; getAvailableApprovers()

Get Available Approvers

### Example

```java
// Import classes:
import dk.signfluent.user.service.invoker.ApiClient;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.invoker.Configuration;
import dk.signfluent.user.service.invoker.models.*;
import dk.signfluent.user.service.api.UserControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8003");

        UserControllerApi apiInstance = new UserControllerApi(defaultClient);
        try {
            List<User> result = apiInstance.getAvailableApprovers();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserControllerApi#getAvailableApprovers");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **201** | Created |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getDevicesForUser

> List&lt;Device&gt; getDevicesForUser(userBasedRequest)

Get Devices For User

### Example

```java
// Import classes:
import dk.signfluent.user.service.invoker.ApiClient;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.invoker.Configuration;
import dk.signfluent.user.service.invoker.models.*;
import dk.signfluent.user.service.api.UserControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8003");

        UserControllerApi apiInstance = new UserControllerApi(defaultClient);
        UserBasedRequest userBasedRequest = new UserBasedRequest(); // UserBasedRequest | userBasedRequest
        try {
            List<Device> result = apiInstance.getDevicesForUser(userBasedRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserControllerApi#getDevicesForUser");
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
 **userBasedRequest** | [**UserBasedRequest**](UserBasedRequest.md)| userBasedRequest |

### Return type

[**List&lt;Device&gt;**](Device.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **201** | Created |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getFCMTokensForUser

> List&lt;String&gt; getFCMTokensForUser(userBasedRequest)

Update FCM Token

### Example

```java
// Import classes:
import dk.signfluent.user.service.invoker.ApiClient;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.invoker.Configuration;
import dk.signfluent.user.service.invoker.models.*;
import dk.signfluent.user.service.api.UserControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8003");

        UserControllerApi apiInstance = new UserControllerApi(defaultClient);
        UserBasedRequest userBasedRequest = new UserBasedRequest(); // UserBasedRequest | userBasedRequest
        try {
            List<String> result = apiInstance.getFCMTokensForUser(userBasedRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserControllerApi#getFCMTokensForUser");
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
 **userBasedRequest** | [**UserBasedRequest**](UserBasedRequest.md)| userBasedRequest |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **201** | Created |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

