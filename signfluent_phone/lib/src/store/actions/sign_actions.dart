import 'package:bpm_service_api/bpm_service_api.dart';
import 'package:redux/redux.dart';
import 'package:redux_thunk/redux_thunk.dart';
import 'package:signfluent_phone/src/model/certificate_storage.dart';
import 'package:signfluent_phone/src/provider/bpm_service_api_provider.dart';
import 'package:signfluent_phone/src/service/rsa_service.dart';
import 'package:signfluent_phone/src/service_location.dart';

final RSAService _rsaService = getIt<RSAService>();
final BpmServiceApiProvider _bpmServiceApiProvider =
    getIt<BpmServiceApiProvider>();

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

      SignfluentSignature signature =
          await _buildSignfluentSignature(currentUserId, taskId, signedHash);
      Future<String> submitSignatureTask =
          _bpmServiceApiProvider.submitSignatureRequest(signature);

      store.dispatch(SendSignatureResponseAction(submitSignatureTask));
    });
  };
}

ThunkAction fetchSignatureRequest() {
  return (Store store) async {
    Future(() {
      Future<SignfluentSignatureRequest> signfluentSignatureRequest =
          _bpmServiceApiProvider.getSignatureRequest();

      store.dispatch(FetchSignatureSuccessAction(signfluentSignatureRequest));
    });
  };
}

Future<SignfluentSignature> _buildSignfluentSignature(
    String currentUserId, String taskId, String signedHash) async {
  String certificate = await _rsaService
      .getCertificateStorage(currentUserId)
      .then((CertificateStorage storage) => storage.x509PEM);

  SignfluentSignatureBuilder builder = SignfluentSignatureBuilder();
  builder.taskId = taskId;
  builder.signedContent = signedHash;
  builder.x509Pem = certificate;
  return builder.build();
}
