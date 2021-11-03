import 'package:test/test.dart';
import 'package:bpm_service_api/bpm_service_api.dart';


/// tests for DeviceControllerApi
void main() {
  final instance = BpmServiceApi().getDeviceControllerApi();

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
