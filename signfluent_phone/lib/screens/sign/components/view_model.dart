import 'package:redux/redux.dart';
import 'package:signfluent_phone/model/signfluent_signature_request.dart';
import 'package:signfluent_phone/store/actions/sign_actions.dart';
import 'package:signfluent_phone/store/state/app_sate.dart';

class SignViewModel {
  bool isLoading = true;
  String userId;
  Future<SignfluentSignatureRequest>? signatureRequest;
  Future<String>? signingResponse;
  Store<AppState> store;

  SignViewModel(
      {required this.isLoading,
      required this.userId,
      required this.signatureRequest,
      required this.signingResponse,
      required this.store});

  static SignViewModel fromStore(Store<AppState> store) {
    return SignViewModel(
        isLoading: store.state.signState.isLoading,
        userId: store.state.userState.authenticationResponse!.user.id,
        signatureRequest: store.state.signState.signatureRequest,
        signingResponse: store.state.signState.signingResponse,
        store: store);
  }

  void fetchSignatureRequests() {
    store.dispatch(fetchSignatureRequest(userId));
  }

  void sign(String taskId, String content) {
    store.dispatch(signContent(taskId, content, userId));
  }
}
