import 'package:redux/redux.dart';
import 'package:signfluent_phone/store/actions/sign_actions.dart';
import 'package:signfluent_phone/store/state/sign_state.dart';

final signReducer = combineReducers<SignState>([
  TypedReducer<SignState, SetConfirmationLoadingAction>(_setLoading),
  TypedReducer<SignState, FetchSignatureSuccessAction>(_setSignatureRequest),
  TypedReducer<SignState, ConfirmSignatureRequestSuccessAction>(
      _clearSignatureRequest),
  TypedReducer<SignState, ConfirmSignatureRequestFailedAction>(_setError),
]);

SignState _setLoading(SignState state, SetConfirmationLoadingAction action) {
  return state.copyWith(isLoading: action.isLoading);
}

SignState _setSignatureRequest(
    SignState state, FetchSignatureSuccessAction action) {
  return state.copyWith(
      isLoading: false, signatureRequest: action.signatureRequest, error: null);
}

SignState _clearSignatureRequest(
    SignState state, ConfirmSignatureRequestSuccessAction action) {
  return state.copyWith(isLoading: false, signatureRequest: null, error: null);
}

SignState _setError(
    SignState state, ConfirmSignatureRequestFailedAction action) {
  return state.copyWith(
      isLoading: false, error: action.errorMessage, signatureRequest: null);
}
