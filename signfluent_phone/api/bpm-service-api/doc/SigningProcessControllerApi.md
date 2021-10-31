# bpm_service_api.api.SigningProcessControllerApi

## Load the API package
```dart
import 'package:bpm_service_api/api.dart';
```

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getActiveApprovers**](SigningProcessControllerApi.md#getactiveapprovers) | **POST** /api/signingProcess/getActiveApprovers | Get active approvers
[**getDocumentDetails**](SigningProcessControllerApi.md#getdocumentdetails) | **POST** /api/signingProcess/getDocumentDetails | Returns document details for specified task
[**getDocumentsForInspection**](SigningProcessControllerApi.md#getdocumentsforinspection) | **POST** /api/signingProcess/getDocumentsForInspection | Returns documents needed inspection
[**inspectDocument**](SigningProcessControllerApi.md#inspectdocument) | **POST** /api/signingProcess/inspectDocument | Inspect document and assign approvers
[**uploadDocument**](SigningProcessControllerApi.md#uploaddocument) | **POST** /api/signingProcess/uploadDocument | Uploads a document


# **getActiveApprovers**
> BuiltList<User> getActiveApprovers()

Get active approvers

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getSigningProcessControllerApi();

try { 
    final response = api.getActiveApprovers();
    print(response);
} catch on DioError (e) {
    print('Exception when calling SigningProcessControllerApi->getActiveApprovers: $e\n');
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

# **getDocumentDetails**
> DocumentWithContent getDocumentDetails(taskIdRequest)

Returns document details for specified task

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getSigningProcessControllerApi();
final TaskIdRequest taskIdRequest = ; // TaskIdRequest | taskIdRequest

try { 
    final response = api.getDocumentDetails(taskIdRequest);
    print(response);
} catch on DioError (e) {
    print('Exception when calling SigningProcessControllerApi->getDocumentDetails: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskIdRequest** | [**TaskIdRequest**](TaskIdRequest.md)| taskIdRequest | 

### Return type

[**DocumentWithContent**](DocumentWithContent.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getDocumentsForInspection**
> BuiltList<DocumentResponse> getDocumentsForInspection()

Returns documents needed inspection

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getSigningProcessControllerApi();

try { 
    final response = api.getDocumentsForInspection();
    print(response);
} catch on DioError (e) {
    print('Exception when calling SigningProcessControllerApi->getDocumentsForInspection: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BuiltList&lt;DocumentResponse&gt;**](DocumentResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **inspectDocument**
> String inspectDocument(inspectDocumentRequest)

Inspect document and assign approvers

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getSigningProcessControllerApi();
final InspectDocumentRequest inspectDocumentRequest = ; // InspectDocumentRequest | inspectDocumentRequest

try { 
    final response = api.inspectDocument(inspectDocumentRequest);
    print(response);
} catch on DioError (e) {
    print('Exception when calling SigningProcessControllerApi->inspectDocument: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **inspectDocumentRequest** | [**InspectDocumentRequest**](InspectDocumentRequest.md)| inspectDocumentRequest | 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **uploadDocument**
> uploadDocument(uploadDocumentRequest)

Uploads a document

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getSigningProcessControllerApi();
final UploadDocumentRequest uploadDocumentRequest = ; // UploadDocumentRequest | uploadDocumentRequest

try { 
    api.uploadDocument(uploadDocumentRequest);
} catch on DioError (e) {
    print('Exception when calling SigningProcessControllerApi->uploadDocument: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uploadDocumentRequest** | [**UploadDocumentRequest**](UploadDocumentRequest.md)| uploadDocumentRequest | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

