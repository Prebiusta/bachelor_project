import 'package:redux/redux.dart';
import 'package:signfluent_phone/src/model/signfluent_signature_request.dart';
import 'package:signfluent_phone/src/store/actions/actions.dart';
import 'package:signfluent_phone/src/store/actions/sign_actions.dart';
import 'package:signfluent_phone/src/store/state/app_sate.dart';

class SignViewModel {
  String userId;
  String fcmToken;
  Future<SignfluentSignatureRequest>? signatureRequest;
  Future<String>? signingResponse;
  Store<AppState> store;

  SignViewModel(
      {required this.userId,
      required this.fcmToken,
      required this.signatureRequest,
      required this.signingResponse,
      required this.store});

  static SignViewModel fromStore(Store<AppState> store) {
    return SignViewModel(
        userId: store.state.userState.authenticationResponse!.userId!,
        fcmToken: store.state.userState.token!,
        signatureRequest: store.state.signState.signatureRequest,
        signingResponse: store.state.signState.signingResponse,
        store: store);
  }

  void setFCMToken() {
    store.dispatch(updateFCMToken(userId, fcmToken));
  }

  void fetchSignatureRequests() {
    store.dispatch(fetchSignatureRequest(userId));
  }

  void sign(String taskId, String content) {
    store.dispatch(signContent(taskId, content, userId));
  }

  void confirmSignatureResponse() {
    store.dispatch(ConfirmSignatureResponseAction());
  }
}
