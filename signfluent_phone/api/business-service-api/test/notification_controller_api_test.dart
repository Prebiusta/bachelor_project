import 'package:test/test.dart';
import 'package:business_service_api/business_service_api.dart';


/// tests for NotificationControllerApi
void main() {
  final instance = BusinessServiceApi().getNotificationControllerApi();

  group(NotificationControllerApi, () {
    // Returns time of daily notifications
    //
    //Future<int> getDailyNotificationTime() async
    test('test getDailyNotificationTime', () async {
      // TODO
    });

    // Modify time of daily notifications
    //
    //Future<int> modifyDailyNotificationTime(ModifyDailyNotificationTimeRequest modifyDailyNotificationTimeRequest) async
    test('test modifyDailyNotificationTime', () async {
      // TODO
    });

  });
}
