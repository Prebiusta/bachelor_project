import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'package:signfluent_phone/src/constants.dart';

class ApiProvider {
  final _storage = const FlutterSecureStorage();

  Future<String?> getBasePath() async {
    return _storage.read(key: basePathKey);
  }
  
  Future<void> setBasePath(String url) async {
    return _storage.write(key: basePathKey, value: url);
  }

}