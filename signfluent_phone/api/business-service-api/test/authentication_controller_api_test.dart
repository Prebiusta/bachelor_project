import 'package:test/test.dart';
import 'package:business_service_api/business_service_api.dart';


/// tests for AuthenticationControllerApi
void main() {
  final instance = BusinessServiceApi().getAuthenticationControllerApi();

  group(AuthenticationControllerApi, () {
    // Authenticates user
    //
    //Future<AuthenticationResponse> login(AuthenticationRequest authenticationRequest) async
    test('test login', () async {
      // TODO
    });

    // Verifies the connection
    //
    //Future<String> ping() async
    test('test ping', () async {
      // TODO
    });

    // Refreshes authentication token
    //
    //Future<AuthenticationResponse> refreshAuthToken(RefreshTokenRequest request) async
    test('test refreshAuthToken', () async {
      // TODO
    });

  });
}
