import 'package:bpm_service_api/bpm_service_api.dart';
import 'package:redux/redux.dart';
import 'package:signfluent_phone/src/store/actions/actions.dart';
import 'package:signfluent_phone/src/store/state/app_sate.dart';

class LoginViewModel {
  final bool isLoading;
  final bool loginError;

  final Function(String, String) login;

  LoginViewModel({
    required this.isLoading,
    required this.loginError,
    required this.login,
  });

  static LoginViewModel fromStore(Store<AppState> store) {
    return LoginViewModel(
      isLoading: store.state.userState.isLoading,
      loginError: store.state.userState.loginError,
      login: (String email, String password) {
        store
            .dispatch(loginUser(email, password, store.state.userState.token!));
      },
    );
  }
}
