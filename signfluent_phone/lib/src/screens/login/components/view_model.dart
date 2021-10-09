import 'package:flutter/foundation.dart';
import 'package:redux/redux.dart';
import 'package:signfluent_phone/src/model/authentication_response.dart';
import 'package:signfluent_phone/src/service/user_service.dart';
import 'package:signfluent_phone/src/store/actions/actions.dart';
import 'package:signfluent_phone/src/store/state/app_sate.dart';

class LoginViewModel {
  final bool isLoading;
  final bool loginError;
  final AuthenticateResponse? authenticateResponse;

  final Function(String, String) login;

  LoginViewModel({
    required this.isLoading,
    required this.loginError,
    required this.authenticateResponse,
    required this.login,
  });

  static LoginViewModel fromStore(Store<AppState> store) {
    return LoginViewModel(
      isLoading: store.state.userState.isLoading,
      loginError: store.state.userState.loginError,
      authenticateResponse: store.state.userState.authenticationResponse,
      login: (String email, String password) {
        store.dispatch(loginUser(email, password));
      },
    );
  }
}