import 'package:test/test.dart';
import 'package:business_service_api/business_service_api.dart';


/// tests for DeviceControllerApi
void main() {
  final instance = BusinessServiceApi().getDeviceControllerApi();

  group(DeviceControllerApi, () {
    // Registers a new device
    //
    //Future<RegisterDeviceResponse> register(RegisterDeviceRequest request) async
    test('test register', () async {
      // TODO
    });

    // Updates FCM token for specified device
    //
    //Future<UpdateFCMTokenResponse> updateFCMToken(UpdateFCMTokenRequest updateFCMTokenRequest) async
    test('test updateFCMToken', () async {
      // TODO
    });

  });
}
