//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_import

import 'package:built_collection/built_collection.dart';
import 'package:built_value/json_object.dart';
import 'package:built_value/serializer.dart';
import 'package:built_value/standard_json_plugin.dart';
import 'package:built_value/iso_8601_date_time_serializer.dart';
import 'package:business_service_api/src/date_serializer.dart';
import 'package:business_service_api/src/model/date.dart';

import 'package:business_service_api/src/model/approval_order_model.dart';
import 'package:business_service_api/src/model/approval_order_response.dart';
import 'package:business_service_api/src/model/approve_document_request.dart';
import 'package:business_service_api/src/model/assign_approvers_request.dart';
import 'package:business_service_api/src/model/authentication_request.dart';
import 'package:business_service_api/src/model/authentication_response.dart';
import 'package:business_service_api/src/model/base_response.dart';
import 'package:business_service_api/src/model/device_entity.dart';
import 'package:business_service_api/src/model/document_details_response.dart';
import 'package:business_service_api/src/model/document_response.dart';
import 'package:business_service_api/src/model/document_with_content.dart';
import 'package:business_service_api/src/model/document_with_process_response.dart';
import 'package:business_service_api/src/model/inspect_document_request.dart';
import 'package:business_service_api/src/model/issue_x509_certificate_request.dart';
import 'package:business_service_api/src/model/modify_daily_notification_time_request.dart';
import 'package:business_service_api/src/model/process_id_request.dart';
import 'package:business_service_api/src/model/refresh_token_request.dart';
import 'package:business_service_api/src/model/register_device_request.dart';
import 'package:business_service_api/src/model/register_device_response.dart';
import 'package:business_service_api/src/model/role_management_request.dart';
import 'package:business_service_api/src/model/signature0.dart';
import 'package:business_service_api/src/model/signfluent_role_response.dart';
import 'package:business_service_api/src/model/signfluent_signature.dart';
import 'package:business_service_api/src/model/signfluent_signature_request.dart';
import 'package:business_service_api/src/model/update_fcm_token_request.dart';
import 'package:business_service_api/src/model/update_fcm_token_response.dart';
import 'package:business_service_api/src/model/upload_document_request.dart';
import 'package:business_service_api/src/model/user.dart';
import 'package:business_service_api/src/model/user0.dart';
import 'package:business_service_api/src/model/user_action_response.dart';
import 'package:business_service_api/src/model/user_create_request.dart';
import 'package:business_service_api/src/model/user_create_response.dart';
import 'package:business_service_api/src/model/user_request.dart';

part 'serializers.g.dart';

@SerializersFor([
  ApprovalOrderModel,
  ApprovalOrderResponse,
  ApproveDocumentRequest,
  AssignApproversRequest,
  AuthenticationRequest,
  AuthenticationResponse,
  BaseResponse,
  DeviceEntity,
  DocumentDetailsResponse,
  DocumentResponse,
  DocumentWithContent,
  DocumentWithProcessResponse,
  InspectDocumentRequest,
  IssueX509CertificateRequest,
  ModifyDailyNotificationTimeRequest,
  ProcessIdRequest,
  RefreshTokenRequest,
  RegisterDeviceRequest,
  RegisterDeviceResponse,
  RoleManagementRequest,
  Signature0,
  SignfluentRoleResponse,
  SignfluentSignature,
  SignfluentSignatureRequest,
  UpdateFCMTokenRequest,
  UpdateFCMTokenResponse,
  UploadDocumentRequest,
  User,
  User0,
  UserActionResponse,
  UserCreateRequest,
  UserCreateResponse,
  UserRequest,
])
Serializers serializers = (_$serializers.toBuilder()
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(DocumentResponse)]),
        () => ListBuilder<DocumentResponse>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(SignfluentRoleResponse)]),
        () => ListBuilder<SignfluentRoleResponse>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(DocumentWithProcessResponse)]),
        () => ListBuilder<DocumentWithProcessResponse>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(User0)]),
        () => ListBuilder<User0>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(User)]),
        () => ListBuilder<User>(),
      )
      ..add(const DateSerializer())
      ..add(Iso8601DateTimeSerializer()))
    .build();

Serializers standardSerializers =
    (serializers.toBuilder()..addPlugin(StandardJsonPlugin())).build();
