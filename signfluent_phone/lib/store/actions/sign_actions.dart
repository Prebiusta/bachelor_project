import 'package:redux/redux.dart';
import 'package:redux_thunk/redux_thunk.dart';
import 'package:signfluent_phone/model/signfluent_signature_request.dart';
import 'package:signfluent_phone/service/rsa_service.dart';
import 'package:signfluent_phone/service/signature_service.dart';
import 'package:signfluent_phone/service_location.dart';

final RSAService _rsaService = getIt<RSAService>();
final SignatureService _signatureService = getIt<SignatureService>();

class SetConfirmationLoadingAction {
  bool isLoading;

  SetConfirmationLoadingAction(this.isLoading);
}

class FetchSignatureSuccessAction {
  Future<SignfluentSignatureRequest> signatureRequest;

  FetchSignatureSuccessAction(this.signatureRequest);
}

class ConfirmSignatureRequestSuccessAction {}

class ConfirmSignatureRequestFailedAction {
  String errorMessage;

  ConfirmSignatureRequestFailedAction(this.errorMessage);
}

ThunkAction signContent(String taskId, String content, String currentUserId) {
  return (Store store) async {
    Future(() async {
      store.dispatch(SetConfirmationLoadingAction(true));
      String signedHash = await _rsaService.sign(content, currentUserId);
      await _signatureService
          .submitSignatureTask(taskId, signedHash, currentUserId)
          .then((value) {
        store.dispatch(ConfirmSignatureRequestSuccessAction());
      }, onError: (_) {
        store.dispatch(
            ConfirmSignatureRequestFailedAction("Failed to sign certificate"));
      });
    });
  };
}

ThunkAction fetchSignatureRequest(String currentUserId) {
  return (Store store) async {
    Future(() {
      store.dispatch(SetConfirmationLoadingAction(true));

      Future<SignfluentSignatureRequest> signfluentSignatureRequest =
          _signatureService.fetchSignatureRequest(currentUserId);

      store.dispatch(FetchSignatureSuccessAction(signfluentSignatureRequest));
    });
  };
}
