# business_service_api.api.UserControllerApi

## Load the API package
```dart
import 'package:business_service_api/api.dart';
```

All URIs are relative to *http://localhost:8006*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](UserControllerApi.md#createuser) | **POST** /api/user/createUser | Creates a new user
[**getAllUsers**](UserControllerApi.md#getallusers) | **POST** /api/user/getAllUsers | Returns all available users
[**getCurrentUserDetails**](UserControllerApi.md#getcurrentuserdetails) | **POST** /api/user/getCurrentUserDetails | Returns details of authenticated user
[**getUserDetails**](UserControllerApi.md#getuserdetails) | **POST** /api/user/getUserDetails/{userId} | Return details of specified user


# **createUser**
> UserCreateResponse createUser(userCreateRequest)

Creates a new user

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getUserControllerApi();
final UserCreateRequest userCreateRequest = ; // UserCreateRequest | userCreateRequest

try { 
    final response = api.createUser(userCreateRequest);
    print(response);
} catch on DioError (e) {
    print('Exception when calling UserControllerApi->createUser: $e\n');
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

# **getAllUsers**
> BuiltList<User> getAllUsers()

Returns all available users

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getUserControllerApi();

try { 
    final response = api.getAllUsers();
    print(response);
} catch on DioError (e) {
    print('Exception when calling UserControllerApi->getAllUsers: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BuiltList&lt;User&gt;**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCurrentUserDetails**
> User getCurrentUserDetails()

Returns details of authenticated user

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getUserControllerApi();

try { 
    final response = api.getCurrentUserDetails();
    print(response);
} catch on DioError (e) {
    print('Exception when calling UserControllerApi->getCurrentUserDetails: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getUserDetails**
> User getUserDetails(userId)

Return details of specified user

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getUserControllerApi();
final String userId = userId_example; // String | userId

try { 
    final response = api.getUserDetails(userId);
    print(response);
} catch on DioError (e) {
    print('Exception when calling UserControllerApi->getUserDetails: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| userId | 

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

