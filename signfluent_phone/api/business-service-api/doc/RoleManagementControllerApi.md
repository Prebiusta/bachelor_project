# business_service_api.api.RoleManagementControllerApi

## Load the API package
```dart
import 'package:business_service_api/api.dart';
```

All URIs are relative to *http://localhost:8006*

Method | HTTP request | Description
------------- | ------------- | -------------
[**assign**](RoleManagementControllerApi.md#assign) | **POST** /api/role/assign | Assign a role to the user
[**getAlForUser**](RoleManagementControllerApi.md#getalforuser) | **POST** /api/role/getForUser | Returns roles for specified user
[**getAll**](RoleManagementControllerApi.md#getall) | **POST** /api/role/getAll | Returns all available roles
[**getAllForCurrentUser**](RoleManagementControllerApi.md#getallforcurrentuser) | **POST** /api/role/getForCurrentUser | Returns all roles for currently authenticated user
[**revoke**](RoleManagementControllerApi.md#revoke) | **POST** /api/role/revoke | Revoke a role from the user


# **assign**
> BaseResponse assign(roleManagementRequest)

Assign a role to the user

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getRoleManagementControllerApi();
final RoleManagementRequest roleManagementRequest = ; // RoleManagementRequest | roleManagementRequest

try { 
    final response = api.assign(roleManagementRequest);
    print(response);
} catch on DioError (e) {
    print('Exception when calling RoleManagementControllerApi->assign: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **roleManagementRequest** | [**RoleManagementRequest**](RoleManagementRequest.md)| roleManagementRequest | 

### Return type

[**BaseResponse**](BaseResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAlForUser**
> BuiltList<SignfluentRoleResponse> getAlForUser(userRequest)

Returns roles for specified user

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getRoleManagementControllerApi();
final UserRequest userRequest = ; // UserRequest | userRequest

try { 
    final response = api.getAlForUser(userRequest);
    print(response);
} catch on DioError (e) {
    print('Exception when calling RoleManagementControllerApi->getAlForUser: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userRequest** | [**UserRequest**](UserRequest.md)| userRequest | 

### Return type

[**BuiltList&lt;SignfluentRoleResponse&gt;**](SignfluentRoleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAll**
> BuiltList<SignfluentRoleResponse> getAll()

Returns all available roles

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getRoleManagementControllerApi();

try { 
    final response = api.getAll();
    print(response);
} catch on DioError (e) {
    print('Exception when calling RoleManagementControllerApi->getAll: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BuiltList&lt;SignfluentRoleResponse&gt;**](SignfluentRoleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAllForCurrentUser**
> BuiltList<SignfluentRoleResponse> getAllForCurrentUser()

Returns all roles for currently authenticated user

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getRoleManagementControllerApi();

try { 
    final response = api.getAllForCurrentUser();
    print(response);
} catch on DioError (e) {
    print('Exception when calling RoleManagementControllerApi->getAllForCurrentUser: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BuiltList&lt;SignfluentRoleResponse&gt;**](SignfluentRoleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **revoke**
> BaseResponse revoke(roleManagementRequest)

Revoke a role from the user

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getRoleManagementControllerApi();
final RoleManagementRequest roleManagementRequest = ; // RoleManagementRequest | roleManagementRequest

try { 
    final response = api.revoke(roleManagementRequest);
    print(response);
} catch on DioError (e) {
    print('Exception when calling RoleManagementControllerApi->revoke: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **roleManagementRequest** | [**RoleManagementRequest**](RoleManagementRequest.md)| roleManagementRequest | 

### Return type

[**BaseResponse**](BaseResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

