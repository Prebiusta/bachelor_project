import 'package:flutter_redux_navigation/flutter_redux_navigation.dart';
import 'package:redux/redux.dart';
import 'package:redux_thunk/redux_thunk.dart';
import 'package:signfluent_phone/src/model/authentication_response.dart';
import 'package:signfluent_phone/src/routes/routes.dart';
import 'package:signfluent_phone/src/service/user_service.dart';
import 'package:signfluent_phone/src/store/state/app_sate.dart';
import 'package:signfluent_phone/src/store/state/user_state.dart';

import '../../service_location.dart';

final UserService _userService = getIt<UserService>();

class LoginSuccessAction {
  AuthenticateResponse authenticateResponse;

  LoginSuccessAction(this.authenticateResponse);
}

class LoginFailedAction {}

class StartUserLoadingAction {}

class SetFCMTokenAction {
  String? token;

  SetFCMTokenAction(this.token);
}

ThunkAction loginUser(String email, String password, String token) {
  return (Store store) async {
    Future(() async {
      store.dispatch(StartUserLoadingAction());
      _userService.authenticate(email, password).then(
              (AuthenticateResponse authenticationResponse) {
            store.dispatch(LoginSuccessAction(authenticationResponse));
            store.dispatch(NavigateToAction.replace(setupBasePath));
          }, onError: (error) {
        store.dispatch(LoginFailedAction());
      });
    });
  };
}

ThunkAction updateFCMToken(String userId, String token) {
  return (Store store) async {
    Future(() async {
      store.dispatch(StartUserLoadingAction());
      _userService.updateFCMToken(
          userId, token);
    });
  };
}

