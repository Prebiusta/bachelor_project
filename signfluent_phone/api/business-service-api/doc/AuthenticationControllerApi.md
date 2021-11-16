# business_service_api.api.AuthenticationControllerApi

## Load the API package
```dart
import 'package:business_service_api/api.dart';
```

All URIs are relative to *http://localhost:8006*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](AuthenticationControllerApi.md#createuser) | **POST** /api/auth/createUser | Creates a new user
[**login**](AuthenticationControllerApi.md#login) | **POST** /api/auth/login | Authenticates user
[**ping**](AuthenticationControllerApi.md#ping) | **GET** /api/auth/ping | Verifies the connection
[**refreshAuthToken**](AuthenticationControllerApi.md#refreshauthtoken) | **POST** /api/auth/refreshToken | Refreshes authentication token


# **createUser**
> UserCreateResponse createUser(userCreateRequest)

Creates a new user

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getAuthenticationControllerApi();
final UserCreateRequest userCreateRequest = ; // UserCreateRequest | userCreateRequest

try { 
    final response = api.createUser(userCreateRequest);
    print(response);
} catch on DioError (e) {
    print('Exception when calling AuthenticationControllerApi->createUser: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userCreateRequest** | [**UserCreateRequest**](UserCreateRequest.md)| userCreateRequest | 

### Return type

[**UserCreateResponse**](UserCreateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **login**
> AuthenticationResponse login(authenticationRequest)

Authenticates user

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getAuthenticationControllerApi();
final AuthenticationRequest authenticationRequest = ; // AuthenticationRequest | authenticationRequest

try { 
    final response = api.login(authenticationRequest);
    print(response);
} catch on DioError (e) {
    print('Exception when calling AuthenticationControllerApi->login: $e\n');
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **ping**
> String ping()

Verifies the connection

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getAuthenticationControllerApi();

try { 
    final response = api.ping();
    print(response);
} catch on DioError (e) {
    print('Exception when calling AuthenticationControllerApi->ping: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **refreshAuthToken**
> AuthenticationResponse refreshAuthToken(request)

Refreshes authentication token

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getAuthenticationControllerApi();
final RefreshTokenRequest request = ; // RefreshTokenRequest | request

try { 
    final response = api.refreshAuthToken(request);
    print(response);
} catch on DioError (e) {
    print('Exception when calling AuthenticationControllerApi->refreshAuthToken: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**RefreshTokenRequest**](RefreshTokenRequest.md)| request | 

### Return type

[**AuthenticationResponse**](AuthenticationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

