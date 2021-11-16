# business_service_api.api.CertificateAuthorityControllerApi

## Load the API package
```dart
import 'package:business_service_api/api.dart';
```

All URIs are relative to *http://localhost:8006*

Method | HTTP request | Description
------------- | ------------- | -------------
[**issueX509Certificate**](CertificateAuthorityControllerApi.md#issuex509certificate) | **POST** /api/certificateAuthority/issueX509Certificate | Issues X509 Certificate and returns in PEM format


# **issueX509Certificate**
> String issueX509Certificate(issueX509CertificateRequest)

Issues X509 Certificate and returns in PEM format

### Example 
```dart
import 'package:business_service_api/api.dart';

final api = BusinessServiceApi().getCertificateAuthorityControllerApi();
final IssueX509CertificateRequest issueX509CertificateRequest = ; // IssueX509CertificateRequest | issueX509CertificateRequest

try { 
    final response = api.issueX509Certificate(issueX509CertificateRequest);
    print(response);
} catch on DioError (e) {
    print('Exception when calling CertificateAuthorityControllerApi->issueX509Certificate: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **issueX509CertificateRequest** | [**IssueX509CertificateRequest**](IssueX509CertificateRequest.md)| issueX509CertificateRequest | 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

