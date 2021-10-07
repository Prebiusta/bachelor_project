import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:signfluent_phone/model/certificate_storage.dart';
import 'package:signfluent_phone/model/signfluent_signature.dart';
import 'package:signfluent_phone/model/signfluent_signature_request.dart';
import 'package:signfluent_phone/service/api_provider.dart';
import 'package:signfluent_phone/service/rsa_service.dart';
import 'package:signfluent_phone/service_location.dart';

class SignatureService {
  final RSAService _rsaService = getIt<RSAService>();
  final ApiProvider _apiProvider = getIt<ApiProvider>();

  Future<String> submitSignatureTask(
      String taskId, String signedHash, String userId) async {
    String certificate = await _rsaService
        .getCertificateStorage(userId)
        .then((CertificateStorage storage) => storage.x509PEM);
    SignfluentSignature signfluentSignature = SignfluentSignature(
        signedHash: signedHash, certificate: certificate, taskId: taskId);

    String? baseURL = await _apiProvider.getBasePath();
    var response = await http.post(
      //TODO: Update Endpoint once having the real one
      Uri.parse('http://10.0.2.2:8003/temp/submit'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(signfluentSignature.toJson()),
    );

    if (response.statusCode == 200) {
      return response.body;
    } else {
      throw Exception('Failed to Retrieve task');
    }
  }

  Future<SignfluentSignatureRequest> fetchSignatureRequest(
      String userId) async {
    final response = await http.post(
      //TODO: Update Endpoint once having the real one
      Uri.parse('http://10.0.2.2:8003/temp/get'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(<String, String>{'userId': userId}),
    );

    if (response.statusCode == 200) {
      return SignfluentSignatureRequest.fromJson(jsonDecode(response.body));
    } else {
      throw Exception('Failed to Retrieve task');
    }
  }
}
