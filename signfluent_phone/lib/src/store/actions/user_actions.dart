import 'package:bpm_service_api/bpm_service_api.dart';
import 'package:flutter_redux_navigation/flutter_redux_navigation.dart';
import 'package:redux/redux.dart';
import 'package:redux_thunk/redux_thunk.dart';
import 'package:signfluent_phone/src/provider/bpm_service_api_provider.dart';
import 'package:signfluent_phone/src/routes/routes.dart';
import 'package:signfluent_phone/src/service/bearer_token_service.dart';
import 'package:signfluent_phone/src/service/device_data_service.dart';

import '../../service_location.dart';

final BpmServiceApiProvider _bpmServiceApiProvider =
    getIt<BpmServiceApiProvider>();
final DeviceDataService _deviceDataService = getIt<DeviceDataService>();
final BearerTokenService _bearerTokenService = getIt<BearerTokenService>();

class LoginSuccessAction {
  AuthenticationResponse authenticationResponse;

  LoginSuccessAction(this.authenticationResponse);
}

class LoginFailedAction {}

class StartUserLoadingAction {}

class SetFCMTokenAction {
  String? token;

  SetFCMTokenAction(this.token);
}

ThunkAction loginUser(String username, String password, String token) {
  return (Store store) async {
    Future(() async {
      store.dispatch(StartUserLoadingAction());
      var authenticationRequestBuilder = AuthenticationRequestBuilder();
      authenticationRequestBuilder.username = username;
      authenticationRequestBuilder.password = password;

      _bpmServiceApiProvider
          .login(authenticationRequestBuilder.build())
          .then((AuthenticationResponse authenticationResponse) {
        _bearerTokenService.setBearerToken(authenticationResponse.token!);
        store.dispatch(LoginSuccessAction(authenticationResponse));
        store.dispatch(NavigateToAction.replace(setupBasePath));
      }).catchError((err) => store.dispatch(LoginFailedAction()));
    });
  };
}

ThunkAction updateFCMToken(String userId, String token) {
  return (Store store) async {
    Future(() async {
      store.dispatch(StartUserLoadingAction());

      var request = UpdateFCMTokenRequestBuilder();
      request.userId = userId;
      request.fcmToken = token;
      request.deviceHardwareId = await _deviceDataService.getDeviceUniqueId();

      _bpmServiceApiProvider.updateFCMToken(request.build());
    });
  };
}
