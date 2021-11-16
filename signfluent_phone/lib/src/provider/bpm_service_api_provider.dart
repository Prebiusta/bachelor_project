import 'dart:io';

import 'package:business_service_api/business_service_api.dart';
import 'package:dio/dio.dart';
import 'package:signfluent_phone/src/service/api_provider.dart';
import 'package:signfluent_phone/src/service/bearer_token_service.dart';
import 'package:signfluent_phone/src/service_location.dart';

class BpmServiceApiProvider {
  final ApiProvider _apiProvider = getIt<ApiProvider>();
  final BearerTokenService _bearerTokenService = getIt<BearerTokenService>();

  Future<AuthenticationControllerApi> getAuthenticationControllerApi(
      bool withAuth) async {
    var client = await _dioClient(withAuth);
    return AuthenticationControllerApi(client, standardSerializers);
  }

  Future<DeviceControllerApi> getDeviceControllerApi() async {
    var client = await _dioClient(true);
    return DeviceControllerApi(client, standardSerializers);
  }

  Future<CertificateAuthorityControllerApi>
      getCertificateAuthorityControllerApi() async {
    var client = await _dioClient(true);
    return CertificateAuthorityControllerApi(client, standardSerializers);
  }

  Future<SigningProcessControllerApi>
  getSigningProcessControllerApi() async {
    var client = await _dioClient(true);
    return SigningProcessControllerApi(client, standardSerializers);
  }

  Future<String> ping() async {
    return (await getAuthenticationControllerApi(false))
        .ping()
        .then((value) => value.data!);
  }

  Future<AuthenticationResponse> login(
      AuthenticationRequest authenticationRequest) async {
    return (await getAuthenticationControllerApi(false))
        .login(authenticationRequest: authenticationRequest)
        .then((value) => value.data!);
  }

  Future<RegisterDeviceResponse> registerDevice(
      RegisterDeviceRequest registerDeviceRequest) async {
    return (await getDeviceControllerApi())
        .register(request: registerDeviceRequest)
        .then((value) => value.data!);
  }

  Future<UpdateFCMTokenResponse> updateFCMToken(
      UpdateFCMTokenRequest updateFCMTokenRequest) async {
    return (await getDeviceControllerApi())
        .updateFCMToken(updateFCMTokenRequest: updateFCMTokenRequest)
        .then((value) => value.data!);
  }

  Future<String> issueX509Certificate(
      IssueX509CertificateRequest issueX509CertificateRequest) async {
    return (await getCertificateAuthorityControllerApi())
        .issueX509Certificate(
            issueX509CertificateRequest: issueX509CertificateRequest)
        .then((value) => value.data!);
  }

  Future<SignfluentSignatureRequest> getSignatureRequest() async {
    return (await getSigningProcessControllerApi()).getSignatureRequest().then((value) => value.data!);
  }

  Future<String> submitSignatureRequest(SignfluentSignature signfluentSignature) async {
    return (await getSigningProcessControllerApi()).submitSignature(signfluentSignature: signfluentSignature).then((value) => value.data!);
  }

  Future<Dio> _dioClient(bool withToken) async {
    Dio dio = Dio();
    dio.options.baseUrl = (await _apiProvider.getBasePath())!;
    if (withToken == true) {
      return _appendBearerToken(dio);
    } else {
      return dio;
    }
  }

  Future<Dio> _appendBearerToken(Dio apiClient) async {
    var bearerToken = (await _bearerTokenService.getBearerToken());
    if (bearerToken != null) {
      apiClient.options.headers = {
        HttpHeaders.authorizationHeader: 'Bearer ' + bearerToken
      };
    }
    return apiClient;
  }
}
