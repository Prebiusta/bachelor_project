import 'dart:async';
import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:signfluent_phone/service/api_provider.dart';
import 'package:signfluent_phone/service_location.dart';



class CertificateAuthorityService {
  final ApiProvider _apiProvider = getIt<ApiProvider>();

  Future<String> issueX509Cert(String userId, String publicKeyPem) async {
    String? baseURL = await _apiProvider.getBasePath();

    final response = await http.post(
      Uri.parse('$baseURL/api/certificateManagement/issue'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(
          <String, String>{'userId': userId, 'publicKeyPem': publicKeyPem}),
    );

    if (response.statusCode == 200) {
      return response.body;
    } else {
      throw Exception('Failed to authenticate.');
    }
  }
}
