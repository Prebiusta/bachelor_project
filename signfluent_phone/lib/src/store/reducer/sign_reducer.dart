import 'package:redux/redux.dart';
import 'package:signfluent_phone/src/store/actions/actions.dart';
import 'package:signfluent_phone/src/store/state/sign_state.dart';

final signReducer = combineReducers<SignState>([
  TypedReducer<SignState, FetchSignatureSuccessAction>(_setSignatureRequest),
  TypedReducer<SignState, ConfirmSignatureResponseAction>(
      _confirmSignatureResponse),
  TypedReducer<SignState, SendSignatureResponseAction>(_setSignatureResponse),
]);

SignState _setSignatureRequest(
    SignState state, FetchSignatureSuccessAction action) {
  return state.copyWith(
      signatureRequest: action.signatureRequest,
      signingResponse: state.signingResponse);
}

SignState _setSignatureResponse(
    SignState state, SendSignatureResponseAction action) {
  return state.copyWith(
      signingResponse: action.signingResponse,
      signatureRequest: state.signatureRequest);
}

SignState _confirmSignatureResponse(
    SignState state, ConfirmSignatureResponseAction action) {
  return state.copyWith(signingResponse: null, signatureRequest: null);
}
