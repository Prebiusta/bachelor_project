import 'package:redux/redux.dart';
import 'package:redux_thunk/redux_thunk.dart';
import 'package:signfluent_phone/src/model/signfluent_signature_request.dart';
import 'package:signfluent_phone/src/service/rsa_service.dart';
import 'package:signfluent_phone/src/service/signature_service.dart';
import 'package:signfluent_phone/src/service_location.dart';

final RSAService _rsaService = getIt<RSAService>();
final SignatureService _signatureService = getIt<SignatureService>();

class FetchSignatureSuccessAction {
  Future<SignfluentSignatureRequest> signatureRequest;

  FetchSignatureSuccessAction(this.signatureRequest);
}

class SendSignatureResponseAction {
  Future<String> signingResponse;

  SendSignatureResponseAction(this.signingResponse);
}

class ConfirmSignatureResponseAction {}

ThunkAction signContent(String taskId, String content, String currentUserId) {
  return (Store store) async {
    Future(() async {
      String signedHash = await _rsaService.sign(content, currentUserId);

      Future<String> submitSignatureTask = _signatureService
          .submitSignatureTask(taskId, signedHash, currentUserId);

      store.dispatch(SendSignatureResponseAction(submitSignatureTask));
    });
  };
}

ThunkAction fetchSignatureRequest(String currentUserId) {
  return (Store store) async {
    Future(() {
      Future<SignfluentSignatureRequest> signfluentSignatureRequest =
          _signatureService.fetchSignatureRequest(currentUserId);

      store.dispatch(FetchSignatureSuccessAction(signfluentSignatureRequest));
    });
  };
}
