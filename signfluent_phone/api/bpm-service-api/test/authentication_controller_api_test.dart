import 'package:test/test.dart';
import 'package:bpm_service_api/bpm_service_api.dart';


/// tests for AuthenticationControllerApi
void main() {
  final instance = BpmServiceApi().getAuthenticationControllerApi();

  group(AuthenticationControllerApi, () {
    // Creates a new user
    //
    //Future<UserCreateResponse> createUser(UserCreateRequest userCreateRequest) async
    test('test createUser', () async {
      // TODO
    });

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
