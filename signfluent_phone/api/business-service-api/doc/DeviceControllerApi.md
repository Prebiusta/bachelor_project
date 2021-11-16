# business_service_api.api.DeviceControllerApi

## Load the API package
```dart
import 'package:business_service_api/api.dart';
```

All URIs are relative to *http://localhost:8006*

Method | HTTP request | Description
------------- | ------------- | -------------
[**register**](DeviceControllerApi.md#register) | **POST** /api/device/register | Registers a new device
[**updateFCMToken**](DeviceControllerApi.md#updatefcmtoken) | **POST** /api/device/updateFCMToken | Updates FCM token for specified device


# **register**
> RegisterDeviceResponse register(request)

Registers a new device

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getDeviceControllerApi();
final RegisterDeviceRequest request = ; // RegisterDeviceRequest | request

try { 
    final response = api.register(request);
    print(response);
} catch on DioError (e) {
    print('Exception when calling DeviceControllerApi->register: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**RegisterDeviceRequest**](RegisterDeviceRequest.md)| request | 

### Return type

[**RegisterDeviceResponse**](RegisterDeviceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateFCMToken**
> UpdateFCMTokenResponse updateFCMToken(updateFCMTokenRequest)

Updates FCM token for specified device

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getDeviceControllerApi();
final UpdateFCMTokenRequest updateFCMTokenRequest = ; // UpdateFCMTokenRequest | updateFCMTokenRequest

try { 
    final response = api.updateFCMToken(updateFCMTokenRequest);
    print(response);
} catch on DioError (e) {
    print('Exception when calling DeviceControllerApi->updateFCMToken: $e\n');
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

