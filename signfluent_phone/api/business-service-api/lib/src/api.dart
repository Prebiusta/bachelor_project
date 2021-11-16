//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:dio/dio.dart';
import 'package:built_value/serializer.dart';
import 'package:business_service_api/src/serializers.dart';
import 'package:business_service_api/src/auth/api_key_auth.dart';
import 'package:business_service_api/src/auth/basic_auth.dart';
import 'package:business_service_api/src/auth/bearer_auth.dart';
import 'package:business_service_api/src/auth/oauth.dart';
import 'package:business_service_api/src/api/authentication_controller_api.dart';
import 'package:business_service_api/src/api/certificate_authority_controller_api.dart';
import 'package:business_service_api/src/api/device_controller_api.dart';
import 'package:business_service_api/src/api/role_management_controller_api.dart';
import 'package:business_service_api/src/api/signing_process_controller_api.dart';

class BusinessServiceApi {
  static const String basePath = r'http://localhost:8006';

  final Dio dio;
  final Serializers serializers;

  BusinessServiceApi({
    Dio? dio,
    Serializers? serializers,
    String? basePathOverride,
    List<Interceptor>? interceptors,
  })  : this.serializers = serializers ?? standardSerializers,
        this.dio = dio ??
            Dio(BaseOptions(
              baseUrl: basePathOverride ?? basePath,
              connectTimeout: 5000,
              receiveTimeout: 3000,
            )) {
    if (interceptors == null) {
      this.dio.interceptors.addAll([
        OAuthInterceptor(),
        BasicAuthInterceptor(),
        BearerAuthInterceptor(),
        ApiKeyAuthInterceptor(),
      ]);
    } else {
      this.dio.interceptors.addAll(interceptors);
    }
  }

  void setOAuthToken(String name, String token) {
    if (this.dio.interceptors.any((i) => i is OAuthInterceptor)) {
      (this.dio.interceptors.firstWhere((i) => i is OAuthInterceptor) as OAuthInterceptor).tokens[name] = token;
    }
  }

  void setBearerAuth(String name, String token) {
    if (this.dio.interceptors.any((i) => i is BearerAuthInterceptor)) {
      (this.dio.interceptors.firstWhere((i) => i is BearerAuthInterceptor) as BearerAuthInterceptor).tokens[name] = token;
    }
  }

  void setBasicAuth(String name, String username, String password) {
    if (this.dio.interceptors.any((i) => i is BasicAuthInterceptor)) {
      (this.dio.interceptors.firstWhere((i) => i is BasicAuthInterceptor) as BasicAuthInterceptor).authInfo[name] = BasicAuthInfo(username, password);
    }
  }

  void setApiKey(String name, String apiKey) {
    if (this.dio.interceptors.any((i) => i is ApiKeyAuthInterceptor)) {
      (this.dio.interceptors.firstWhere((element) => element is ApiKeyAuthInterceptor) as ApiKeyAuthInterceptor).apiKeys[name] = apiKey;
    }
  }

  /// Get AuthenticationControllerApi instance, base route and serializer can be overridden by a given but be careful,
  /// by doing that all interceptors will not be executed
  AuthenticationControllerApi getAuthenticationControllerApi() {
    return AuthenticationControllerApi(dio, serializers);
  }

  /// Get CertificateAuthorityControllerApi instance, base route and serializer can be overridden by a given but be careful,
  /// by doing that all interceptors will not be executed
  CertificateAuthorityControllerApi getCertificateAuthorityControllerApi() {
    return CertificateAuthorityControllerApi(dio, serializers);
  }

  /// Get DeviceControllerApi instance, base route and serializer can be overridden by a given but be careful,
  /// by doing that all interceptors will not be executed
  DeviceControllerApi getDeviceControllerApi() {
    return DeviceControllerApi(dio, serializers);
  }

  /// Get RoleManagementControllerApi instance, base route and serializer can be overridden by a given but be careful,
  /// by doing that all interceptors will not be executed
  RoleManagementControllerApi getRoleManagementControllerApi() {
    return RoleManagementControllerApi(dio, serializers);
  }

  /// Get SigningProcessControllerApi instance, base route and serializer can be overridden by a given but be careful,
  /// by doing that all interceptors will not be executed
  SigningProcessControllerApi getSigningProcessControllerApi() {
    return SigningProcessControllerApi(dio, serializers);
  }
}
