# bpm_service_api.api.PocControllerApi

## Load the API package
```dart
import 'package:bpm_service_api/api.dart';
```

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**fetchDocumentUsingPOST**](PocControllerApi.md#fetchdocumentusingpost) | **POST** /api/poc/retrieve/{taskID} | fetchDocument
[**startProcessUsingGET**](PocControllerApi.md#startprocessusingget) | **GET** /api/poc/start | startProcess
[**uploadDocumentIdUsingPOST**](PocControllerApi.md#uploaddocumentidusingpost) | **POST** /api/poc/upload/{taskID}/{docID} | uploadDocumentId
[**uploadDocumentUsingGET**](PocControllerApi.md#uploaddocumentusingget) | **GET** /api/poc/uploadDocument | uploadDocument


# **fetchDocumentUsingPOST**
> JsonObject fetchDocumentUsingPOST(taskID)

fetchDocument

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getPocControllerApi();
final String taskID = taskID_example; // String | taskID

try { 
    final response = api.fetchDocumentUsingPOST(taskID);
    print(response);
} catch on DioError (e) {
    print('Exception when calling PocControllerApi->fetchDocumentUsingPOST: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskID** | **String**| taskID | 

### Return type

[**JsonObject**](JsonObject.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **startProcessUsingGET**
> String startProcessUsingGET()

startProcess

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getPocControllerApi();

try { 
    final response = api.startProcessUsingGET();
    print(response);
} catch on DioError (e) {
    print('Exception when calling PocControllerApi->startProcessUsingGET: $e\n');
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

# **uploadDocumentIdUsingPOST**
> uploadDocumentIdUsingPOST(docID, taskID)

uploadDocumentId

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getPocControllerApi();
final String docID = docID_example; // String | docID
final String taskID = taskID_example; // String | taskID

try { 
    api.uploadDocumentIdUsingPOST(docID, taskID);
} catch on DioError (e) {
    print('Exception when calling PocControllerApi->uploadDocumentIdUsingPOST: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **docID** | **String**| docID | 
 **taskID** | **String**| taskID | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **uploadDocumentUsingGET**
> String uploadDocumentUsingGET(document)

uploadDocument

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getPocControllerApi();
final Document document = ; // Document | document

try { 
    final response = api.uploadDocumentUsingGET(document);
    print(response);
} catch on DioError (e) {
    print('Exception when calling PocControllerApi->uploadDocumentUsingGET: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **document** | [**Document**](Document.md)| document | 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

