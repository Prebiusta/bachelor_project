import 'dart:async';
import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:signfluent_phone/src/model/authentication_response.dart';
import 'package:signfluent_phone/src/service/api_provider.dart';
import 'package:signfluent_phone/src/service/device_data_service.dart';
import 'package:signfluent_phone/src/service_location.dart';

class UserService {
  final ApiProvider _apiProvider = getIt<ApiProvider>();
  final DeviceDataService _deviceDataService = getIt<DeviceDataService>();

  Future<void> updateFCMToken(String userId, String token) async {
    String? baseURL = await _apiProvider.getBasePath();
    await http.post(
      Uri.parse('http://10.0.2.2:8003/api/deviceManagement/updateFCMToken'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body:
      jsonEncode(<String, String>{'userId': userId, 'fcmToken': token, 'deviceId': await _deviceDataService.getDeviceUniqueId()}),
    );
  }

  Future<void> registerDevice(String userId, String deviceId) async {
    String? baseURL = await _apiProvider.getBasePath();
    await http.post(
      Uri.parse('http://10.0.2.2:8003/api/deviceManagement/registerDevice'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body:
          jsonEncode(<String, String>{'userId': userId, 'deviceId': deviceId}),
    );
  }

  Future<AuthenticateResponse> authenticate(
      String email, String password) async {
    String? baseURL = await _apiProvider.getBasePath();

    final response = await http.post(
      Uri.parse('http://10.0.2.2:8003/api/userManagement/authenticate'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(<String, String>{'email': email, 'password': password}),
    );

    if (response.statusCode == 200) {
      return AuthenticateResponse.fromJson(jsonDecode(response.body));
    } else {
      throw Exception('Failed to authenticate.');
    }
  }

  Future<bool> ping(String url) async {
    final response = await http.get(
      Uri.parse('$url/ping'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
    );

    return response.body == "pong";
  }
}

// http://10.0.2.2:8003
