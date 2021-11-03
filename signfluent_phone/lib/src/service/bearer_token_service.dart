import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'package:signfluent_phone/src/constants.dart';

class BearerTokenService {
  final _storage = const FlutterSecureStorage();

  Future<String?> getBearerToken() async {
    return _storage.read(key: bearerTokenKey);
  }

  Future<void> setBearerToken(String token) async {
    return _storage.write(key: bearerTokenKey, value: token);
  }

  Future<void> deleteBearerToken() async {
    return _storage.delete(key: bearerTokenKey);
  }
}