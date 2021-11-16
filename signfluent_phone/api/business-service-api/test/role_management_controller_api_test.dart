import 'package:test/test.dart';
import 'package:business_service_api/business_service_api.dart';


/// tests for RoleManagementControllerApi
void main() {
  final instance = BusinessServiceApi().getRoleManagementControllerApi();

  group(RoleManagementControllerApi, () {
    // Assign a role to the user
    //
    //Future<BaseResponse> assign(RoleManagementRequest roleManagementRequest) async
    test('test assign', () async {
      // TODO
    });

    // Returns roles for specified user
    //
    //Future<BuiltList<SignfluentRoleResponse>> getAlForUser(UserRequest userRequest) async
    test('test getAlForUser', () async {
      // TODO
    });

    // Returns all available roles
    //
    //Future<BuiltList<SignfluentRoleResponse>> getAll() async
    test('test getAll', () async {
      // TODO
    });

    // Returns all roles for currently authenticated user
    //
    //Future<BuiltList<SignfluentRoleResponse>> getAllForCurrentUser() async
    test('test getAllForCurrentUser', () async {
      // TODO
    });

    // Revoke a role from the user
    //
    //Future<BaseResponse> revoke(RoleManagementRequest roleManagementRequest) async
    test('test revoke', () async {
      // TODO
    });

  });
}
