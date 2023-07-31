# business_service_api (EXPERIMENTAL)
DESCRIPTION

This Dart package is automatically generated by the [OpenAPI Generator](https://openapi-generator.tech) project:

- API version: VERSION
- Build package: org.openapitools.codegen.languages.DartDioNextClientCodegen

## Requirements

* Dart 2.12.0 or later OR Flutter 1.26.0 or later
* Dio 4.0.0+

## Installation & Usage

### pub.dev
To use the package from [pub.dev](https://pub.dev), please include the following in pubspec.yaml
```yaml
dependencies:
  business_service_api: 1.0.0
```

### Github
If this Dart package is published to Github, please include the following in pubspec.yaml
```yaml
dependencies:
  business_service_api:
    git:
      url: https://github.com/GIT_USER_ID/GIT_REPO_ID.git
      #ref: main
```

### Local development
To use the package from your local drive, please include the following in pubspec.yaml
```yaml
dependencies:
  business_service_api:
    path: /path/to/business_service_api
```

## Getting Started

Please follow the [installation procedure](#installation--usage) and then run the following:

```dart
import 'package:business_service_api/business_service_api.dart';


final api = BusinessServiceApi().getAuthenticationControllerApi();
final AuthenticationRequest authenticationRequest = ; // AuthenticationRequest | authenticationRequest

try {
    final response = await api.login(authenticationRequest);
    print(response);
} catch on DioError (e) {
    print("Exception when calling AuthenticationControllerApi->login: $e\n");
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8006*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
[*AuthenticationControllerApi*](doc/AuthenticationControllerApi.md) | [**login**](doc/AuthenticationControllerApi.md#login) | **POST** /api/auth/login | Authenticates user
[*AuthenticationControllerApi*](doc/AuthenticationControllerApi.md) | [**ping**](doc/AuthenticationControllerApi.md#ping) | **GET** /api/auth/ping | Verifies the connection
[*AuthenticationControllerApi*](doc/AuthenticationControllerApi.md) | [**refreshAuthToken**](doc/AuthenticationControllerApi.md#refreshauthtoken) | **POST** /api/auth/refreshToken | Refreshes authentication token
[*CertificateAuthorityControllerApi*](doc/CertificateAuthorityControllerApi.md) | [**issueX509Certificate**](doc/CertificateAuthorityControllerApi.md#issuex509certificate) | **POST** /api/certificateAuthority/issueX509Certificate | Issues X509 Certificate and returns in PEM format
[*DeviceControllerApi*](doc/DeviceControllerApi.md) | [**register**](doc/DeviceControllerApi.md#register) | **POST** /api/device/register | Registers a new device
[*DeviceControllerApi*](doc/DeviceControllerApi.md) | [**updateFCMToken**](doc/DeviceControllerApi.md#updatefcmtoken) | **POST** /api/device/updateFCMToken | Updates FCM token for specified device
[*DocumentControllerApi*](doc/DocumentControllerApi.md) | [**getAllDocuments**](doc/DocumentControllerApi.md#getalldocuments) | **POST** /api/document/getAll | Returns all available documents
[*DocumentControllerApi*](doc/DocumentControllerApi.md) | [**getDocumentDetails**](doc/DocumentControllerApi.md#getdocumentdetails) | **POST** /api/document/get/{documentId} | Returns details for selected documents
[*DocumentControllerApi*](doc/DocumentControllerApi.md) | [**getOwnDocuments**](doc/DocumentControllerApi.md#getowndocuments) | **POST** /api/document/getOwn | Returns documents own by authenticated user
[*NotificationControllerApi*](doc/NotificationControllerApi.md) | [**getDailyNotificationTime**](doc/NotificationControllerApi.md#getdailynotificationtime) | **POST** /api/notifications/getDailyNotificationTime | Returns time of daily notifications
[*NotificationControllerApi*](doc/NotificationControllerApi.md) | [**modifyDailyNotificationTime**](doc/NotificationControllerApi.md#modifydailynotificationtime) | **POST** /api/notifications/modifyDailyNotificationTime | Modify time of daily notifications
[*RoleManagementControllerApi*](doc/RoleManagementControllerApi.md) | [**assign**](doc/RoleManagementControllerApi.md#assign) | **POST** /api/role/assign | Assign a role to the user
[*RoleManagementControllerApi*](doc/RoleManagementControllerApi.md) | [**getAlForUser**](doc/RoleManagementControllerApi.md#getalforuser) | **POST** /api/role/getForUser | Returns roles for specified user
[*RoleManagementControllerApi*](doc/RoleManagementControllerApi.md) | [**getAll**](doc/RoleManagementControllerApi.md#getall) | **POST** /api/role/getAll | Returns all available roles
[*RoleManagementControllerApi*](doc/RoleManagementControllerApi.md) | [**getAllForCurrentUser**](doc/RoleManagementControllerApi.md#getallforcurrentuser) | **POST** /api/role/getForCurrentUser | Returns all roles for currently authenticated user
[*RoleManagementControllerApi*](doc/RoleManagementControllerApi.md) | [**revoke**](doc/RoleManagementControllerApi.md#revoke) | **POST** /api/role/revoke | Revoke a role from the user
[*SigningProcessControllerApi*](doc/SigningProcessControllerApi.md) | [**approveDocument**](doc/SigningProcessControllerApi.md#approvedocument) | **POST** /api/signingProcess/approveDocument | Submit approve document decision
[*SigningProcessControllerApi*](doc/SigningProcessControllerApi.md) | [**assignApprovers**](doc/SigningProcessControllerApi.md#assignapprovers) | **POST** /api/signingProcess/assignApprovers | Assign approvers to a document
[*SigningProcessControllerApi*](doc/SigningProcessControllerApi.md) | [**getActiveApprovers**](doc/SigningProcessControllerApi.md#getactiveapprovers) | **POST** /api/signingProcess/getActiveApprovers | Get active approvers
[*SigningProcessControllerApi*](doc/SigningProcessControllerApi.md) | [**getDocumentDetails1**](doc/SigningProcessControllerApi.md#getdocumentdetails1) | **POST** /api/signingProcess/getDocumentDetails | Returns document details for specified task
[*SigningProcessControllerApi*](doc/SigningProcessControllerApi.md) | [**getDocumentsForApproval**](doc/SigningProcessControllerApi.md#getdocumentsforapproval) | **POST** /api/signingProcess/getDocumentsForApproval | Returns documents needed User&#39;s approval
[*SigningProcessControllerApi*](doc/SigningProcessControllerApi.md) | [**getDocumentsForInspection**](doc/SigningProcessControllerApi.md#getdocumentsforinspection) | **POST** /api/signingProcess/getDocumentsForInspection | Returns documents needed inspection
[*SigningProcessControllerApi*](doc/SigningProcessControllerApi.md) | [**getSignatureRequest**](doc/SigningProcessControllerApi.md#getsignaturerequest) | **POST** /api/signingProcess/getSignatureRequest | Returns signature request for authenticated user
[*SigningProcessControllerApi*](doc/SigningProcessControllerApi.md) | [**inspectDocument**](doc/SigningProcessControllerApi.md#inspectdocument) | **POST** /api/signingProcess/inspectDocument | Inspect document and assign approvers
[*SigningProcessControllerApi*](doc/SigningProcessControllerApi.md) | [**submitSignature**](doc/SigningProcessControllerApi.md#submitsignature) | **POST** /api/signingProcess/submitSignature | Submits document signature
[*SigningProcessControllerApi*](doc/SigningProcessControllerApi.md) | [**uploadDocument**](doc/SigningProcessControllerApi.md#uploaddocument) | **POST** /api/signingProcess/uploadDocument | Uploads a document
[*UserControllerApi*](doc/UserControllerApi.md) | [**createUser**](doc/UserControllerApi.md#createuser) | **POST** /api/user/createUser | Creates a new user
[*UserControllerApi*](doc/UserControllerApi.md) | [**getAllUsers**](doc/UserControllerApi.md#getallusers) | **POST** /api/user/getAllUsers | Returns all available users
[*UserControllerApi*](doc/UserControllerApi.md) | [**getCurrentUserDetails**](doc/UserControllerApi.md#getcurrentuserdetails) | **POST** /api/user/getCurrentUserDetails | Returns details of authenticated user
[*UserControllerApi*](doc/UserControllerApi.md) | [**getUserDetails**](doc/UserControllerApi.md#getuserdetails) | **POST** /api/user/getUserDetails/{userId} | Return details of specified user


## Documentation For Models

 - [ApprovalOrderModel](doc/ApprovalOrderModel.md)
 - [ApprovalOrderResponse](doc/ApprovalOrderResponse.md)
 - [ApproveDocumentRequest](doc/ApproveDocumentRequest.md)
 - [AssignApproversRequest](doc/AssignApproversRequest.md)
 - [AuthenticationRequest](doc/AuthenticationRequest.md)
 - [AuthenticationResponse](doc/AuthenticationResponse.md)
 - [BaseResponse](doc/BaseResponse.md)
 - [DeviceEntity](doc/DeviceEntity.md)
 - [DocumentDetailsResponse](doc/DocumentDetailsResponse.md)
 - [DocumentResponse](doc/DocumentResponse.md)
 - [DocumentWithContent](doc/DocumentWithContent.md)
 - [DocumentWithProcessResponse](doc/DocumentWithProcessResponse.md)
 - [InspectDocumentRequest](doc/InspectDocumentRequest.md)
 - [IssueX509CertificateRequest](doc/IssueX509CertificateRequest.md)
 - [ModifyDailyNotificationTimeRequest](doc/ModifyDailyNotificationTimeRequest.md)
 - [ProcessIdRequest](doc/ProcessIdRequest.md)
 - [RefreshTokenRequest](doc/RefreshTokenRequest.md)
 - [RegisterDeviceRequest](doc/RegisterDeviceRequest.md)
 - [RegisterDeviceResponse](doc/RegisterDeviceResponse.md)
 - [RoleManagementRequest](doc/RoleManagementRequest.md)
 - [Signature0](doc/Signature0.md)
 - [SignfluentRoleResponse](doc/SignfluentRoleResponse.md)
 - [SignfluentSignature](doc/SignfluentSignature.md)
 - [SignfluentSignatureRequest](doc/SignfluentSignatureRequest.md)
 - [UpdateFCMTokenRequest](doc/UpdateFCMTokenRequest.md)
 - [UpdateFCMTokenResponse](doc/UpdateFCMTokenResponse.md)
 - [UploadDocumentRequest](doc/UploadDocumentRequest.md)
 - [User](doc/User.md)
 - [User0](doc/User0.md)
 - [UserActionResponse](doc/UserActionResponse.md)
 - [UserCreateRequest](doc/UserCreateRequest.md)
 - [UserCreateResponse](doc/UserCreateResponse.md)
 - [UserRequest](doc/UserRequest.md)


## Documentation For Authorization

 All endpoints do not require authorization.


## Author



