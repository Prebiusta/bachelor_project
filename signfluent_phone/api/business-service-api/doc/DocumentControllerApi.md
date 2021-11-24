# business_service_api.api.DocumentControllerApi

## Load the API package
```dart
import 'package:business_service_api/api.dart';
```

All URIs are relative to *http://localhost:8006*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllDocuments**](DocumentControllerApi.md#getalldocuments) | **POST** /api/document/getAll | Returns all available documents
[**getDocumentDetails**](DocumentControllerApi.md#getdocumentdetails) | **POST** /api/document/get/{documentId} | Returns details for selected documents
[**getOwnDocuments**](DocumentControllerApi.md#getowndocuments) | **POST** /api/document/getOwn | Returns documents own by authenticated user


# **getAllDocuments**
> BuiltList<DocumentResponse> getAllDocuments()

Returns all available documents

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getDocumentControllerApi();

try { 
    final response = api.getAllDocuments();
    print(response);
} catch on DioError (e) {
    print('Exception when calling DocumentControllerApi->getAllDocuments: $e\n');
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

# **getDocumentDetails**
> DocumentDetailsResponse getDocumentDetails(documentId)

Returns details for selected documents

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getDocumentControllerApi();
final String documentId = documentId_example; // String | documentId

try { 
    final response = api.getDocumentDetails(documentId);
    print(response);
} catch on DioError (e) {
    print('Exception when calling DocumentControllerApi->getDocumentDetails: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **documentId** | **String**| documentId | 

### Return type

[**DocumentDetailsResponse**](DocumentDetailsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getOwnDocuments**
> BuiltList<DocumentResponse> getOwnDocuments()

Returns documents own by authenticated user

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getDocumentControllerApi();

try { 
    final response = api.getOwnDocuments();
    print(response);
} catch on DioError (e) {
    print('Exception when calling DocumentControllerApi->getOwnDocuments: $e\n');
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

