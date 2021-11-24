# business_service_api.api.NotificationControllerApi

## Load the API package
```dart
import 'package:business_service_api/api.dart';
```

All URIs are relative to *http://localhost:8006*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getDailyNotificationTime**](NotificationControllerApi.md#getdailynotificationtime) | **POST** /api/notifications/getDailyNotificationTime | Returns time of daily notifications
[**modifyDailyNotificationTime**](NotificationControllerApi.md#modifydailynotificationtime) | **POST** /api/notifications/modifyDailyNotificationTime | Modify time of daily notifications


# **getDailyNotificationTime**
> int getDailyNotificationTime()

Returns time of daily notifications

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getNotificationControllerApi();

try { 
    final response = api.getDailyNotificationTime();
    print(response);
} catch on DioError (e) {
    print('Exception when calling NotificationControllerApi->getDailyNotificationTime: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**int**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **modifyDailyNotificationTime**
> int modifyDailyNotificationTime(modifyDailyNotificationTimeRequest)

Modify time of daily notifications

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getNotificationControllerApi();
final ModifyDailyNotificationTimeRequest modifyDailyNotificationTimeRequest = ; // ModifyDailyNotificationTimeRequest | modifyDailyNotificationTimeRequest

try { 
    final response = api.modifyDailyNotificationTime(modifyDailyNotificationTimeRequest);
    print(response);
} catch on DioError (e) {
    print('Exception when calling NotificationControllerApi->modifyDailyNotificationTime: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **modifyDailyNotificationTimeRequest** | [**ModifyDailyNotificationTimeRequest**](ModifyDailyNotificationTimeRequest.md)| modifyDailyNotificationTimeRequest | 

### Return type

**int**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

