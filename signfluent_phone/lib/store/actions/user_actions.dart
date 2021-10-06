import 'package:flutter_redux_navigation/flutter_redux_navigation.dart';
import 'package:redux/redux.dart';
import 'package:redux_thunk/redux_thunk.dart';
import 'package:signfluent_phone/model/authentication_response.dart';
import 'package:signfluent_phone/routes/routes.dart';
import 'package:signfluent_phone/service/user_service.dart';

import '../../service_location.dart';

final UserService _userService = getIt<UserService>();

class LoginSuccessAction {
  AuthenticateResponse authenticateResponse;

  LoginSuccessAction(this.authenticateResponse);
}

class LoginFailedAction {}

class StartUserLoadingAction {}

ThunkAction loginUser(String email, String password) {
  return (Store store) async {
    Future(() async {
      store.dispatch(StartUserLoadingAction());
      _userService.authenticate(email, password).then(
          (AuthenticateResponse authenticationResponse) {
        store.dispatch(LoginSuccessAction(authenticationResponse));
        store.dispatch(NavigateToAction.push(setupBasePath));
      }, onError: (error) {
        store.dispatch(LoginFailedAction());
      });
    });
  };
}
