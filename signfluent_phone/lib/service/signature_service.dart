import 'dart:convert';

import 'package:signfluent_phone/model/certificate_storage.dart';
import 'package:signfluent_phone/model/signfluent_signature.dart';
import 'package:signfluent_phone/service/api_provider.dart';
import 'package:signfluent_phone/service/rsa_service.dart';
import 'package:signfluent_phone/service_location.dart';

import 'package:http/http.dart' as http;


class SignatureService {
  final RSAService _rsaService = getIt<RSAService>();
  final ApiProvider _apiProvider = getIt<ApiProvider>();
  
  Future<void> sign(String signedHash, String userId) async {
    String certificate = await _rsaService.getCertificateStorage(userId).then((CertificateStorage storage) => storage.x509PEM);
    SignfluentSignature signfluentSignature = SignfluentSignature(signedHash: signedHash, certificate: certificate);
    
    String? baseURL = await _apiProvider.getBasePath();
    await http.post(
      Uri.parse('$baseURL/api/deviceManagement/registerDevice'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: signfluentSignature.toJson(),
    );
  }
}