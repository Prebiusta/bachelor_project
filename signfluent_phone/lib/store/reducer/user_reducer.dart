import 'package:redux/redux.dart';
import 'package:signfluent_phone/store/actions/actions.dart';
import 'package:signfluent_phone/store/state/user_state.dart';

final userReducer = combineReducers<UserState>([
  TypedReducer<UserState, LoginSuccessAction>(_loginSuccess),
  TypedReducer<UserState, LoginFailedAction>(_loginFailed),
  TypedReducer<UserState, StartUserLoadingAction>(_startLoading),
]);

UserState _loginSuccess(UserState state, LoginSuccessAction action) {
  return state.copyWith(authenticationResponse: action.authenticateResponse, loginError: false);
}

UserState _loginFailed(UserState state, LoginFailedAction action) {
  return state.copyWith(loginError: true, isLoading: false);
}

UserState _startLoading(UserState state, StartUserLoadingAction action) {
  return state.copyWith(isLoading: true);
}
