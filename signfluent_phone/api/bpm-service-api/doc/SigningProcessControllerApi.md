# bpm_service_api.api.SigningProcessControllerApi

## Load the API package
```dart
import 'package:bpm_service_api/api.dart';
```

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**approveDocument**](SigningProcessControllerApi.md#approvedocument) | **POST** /api/signingProcess/approveDocument | Submit approve document decision
[**assignApprovers**](SigningProcessControllerApi.md#assignapprovers) | **POST** /api/signingProcess/assignApprovers | Assign approvers to a document
[**getActiveApprovers**](SigningProcessControllerApi.md#getactiveapprovers) | **POST** /api/signingProcess/getActiveApprovers | Get active approvers
[**getDocumentDetails**](SigningProcessControllerApi.md#getdocumentdetails) | **POST** /api/signingProcess/getDocumentDetails | Returns document details for specified task
[**getDocumentsForApproval**](SigningProcessControllerApi.md#getdocumentsforapproval) | **POST** /api/signingProcess/getDocumentsForApproval | Returns documents needed User&#39;s approval
[**getDocumentsForInspection**](SigningProcessControllerApi.md#getdocumentsforinspection) | **POST** /api/signingProcess/getDocumentsForInspection | Returns documents needed inspection
[**getSignatureRequest**](SigningProcessControllerApi.md#getsignaturerequest) | **POST** /api/signingProcess/getSignatureRequest | Returns signature request for authenticated user
[**inspectDocument**](SigningProcessControllerApi.md#inspectdocument) | **POST** /api/signingProcess/inspectDocument | Inspect document and assign approvers
[**submitSignature**](SigningProcessControllerApi.md#submitsignature) | **POST** /api/signingProcess/submitSignature | Submits document signature
[**uploadDocument**](SigningProcessControllerApi.md#uploaddocument) | **POST** /api/signingProcess/uploadDocument | Uploads a document


# **approveDocument**
> String approveDocument(approverDocumentRequest)

Submit approve document decision

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getSigningProcessControllerApi();
final ApproverDocumentRequest approverDocumentRequest = ; // ApproverDocumentRequest | approverDocumentRequest

try { 
    final response = api.approveDocument(approverDocumentRequest);
    print(response);
} catch on DioError (e) {
    print('Exception when calling SigningProcessControllerApi->approveDocument: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **approverDocumentRequest** | [**ApproverDocumentRequest**](ApproverDocumentRequest.md)| approverDocumentRequest | 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **assignApprovers**
> String assignApprovers(assignApproversRequest)

Assign approvers to a document

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getSigningProcessControllerApi();
final AssignApproversRequest assignApproversRequest = ; // AssignApproversRequest | assignApproversRequest

try { 
    final response = api.assignApprovers(assignApproversRequest);
    print(response);
} catch on DioError (e) {
    print('Exception when calling SigningProcessControllerApi->assignApprovers: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **assignApproversRequest** | [**AssignApproversRequest**](AssignApproversRequest.md)| assignApproversRequest | 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

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
final ProcessIdRequest taskIdRequest = ; // ProcessIdRequest | taskIdRequest

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
 **taskIdRequest** | [**ProcessIdRequest**](ProcessIdRequest.md)| taskIdRequest | 

### Return type

[**DocumentWithContent**](DocumentWithContent.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getDocumentsForApproval**
> BuiltList<DocumentResponse> getDocumentsForApproval()

Returns documents needed User's approval

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getSigningProcessControllerApi();

try { 
    final response = api.getDocumentsForApproval();
    print(response);
} catch on DioError (e) {
    print('Exception when calling SigningProcessControllerApi->getDocumentsForApproval: $e\n');
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

# **getSignatureRequest**
> SignfluentSignatureRequest getSignatureRequest()

Returns signature request for authenticated user

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getSigningProcessControllerApi();

try { 
    final response = api.getSignatureRequest();
    print(response);
} catch on DioError (e) {
    print('Exception when calling SigningProcessControllerApi->getSignatureRequest: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SignfluentSignatureRequest**](SignfluentSignatureRequest.md)

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

# **submitSignature**
> String submitSignature(signfluentSignature)

Submits document signature

### Example 
```dart
import 'package:bpm_service_api/api.dart';

final api = BpmServiceApi().getSigningProcessControllerApi();
final SignfluentSignature signfluentSignature = ; // SignfluentSignature | signfluentSignature

try { 
    final response = api.submitSignature(signfluentSignature);
    print(response);
} catch on DioError (e) {
    print('Exception when calling SigningProcessControllerApi->submitSignature: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **signfluentSignature** | [**SignfluentSignature**](SignfluentSignature.md)| signfluentSignature | 

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

