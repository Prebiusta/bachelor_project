import 'package:test/test.dart';
import 'package:business_service_api/business_service_api.dart';


/// tests for UserControllerApi
void main() {
  final instance = BusinessServiceApi().getUserControllerApi();

  group(UserControllerApi, () {
    // Creates a new user
    //
    //Future<UserCreateResponse> createUser(UserCreateRequest userCreateRequest) async
    test('test createUser', () async {
      // TODO
    });

    // Returns all available users
    //
    //Future<BuiltList<User>> getAllUsers() async
    test('test getAllUsers', () async {
      // TODO
    });

    // Returns details of authenticated user
    //
    //Future<User> getCurrentUserDetails() async
    test('test getCurrentUserDetails', () async {
      // TODO
    });

    // Return details of specified user
    //
    //Future<User> getUserDetails(String userId) async
    test('test getUserDetails', () async {
      // TODO
    });

  });
}
