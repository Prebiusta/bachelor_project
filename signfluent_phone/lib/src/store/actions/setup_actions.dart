import 'package:bpm_service_api/bpm_service_api.dart';
import 'package:flutter_redux_navigation/flutter_redux_navigation.dart';
import 'package:pointycastle/api.dart';
import 'package:redux/redux.dart';
import 'package:redux_thunk/redux_thunk.dart';
import 'package:signfluent_phone/src/model/certificate_storage.dart';
import 'package:signfluent_phone/src/provider/bpm_service_api_provider.dart';
import 'package:signfluent_phone/src/routes/routes.dart';
import 'package:signfluent_phone/src/service/device_data_service.dart';
import 'package:signfluent_phone/src/service/rsa_service.dart';

import '../../service_location.dart';

final RSAService _rsaService = getIt<RSAService>();

final BpmServiceApiProvider _bpmServiceApiProvider =
    getIt<BpmServiceApiProvider>();

final DeviceDataService _deviceDataService = getIt<DeviceDataService>();

class SetSetupLoadingAction {
  bool isLoading;

  SetSetupLoadingAction(this.isLoading);
}

ThunkAction initiateSetup(String userId) {
  return (Store store) async {
    Future(() async {
      try {
        await _rsaService.getCertificateStorage(userId);
        store.dispatch(NavigateToAction.replace(signBasePath));
      } catch (e) {
        var asymmetricKeyPair = await _rsaService.generateKeyPair();

        String x509Pem = await issueX509Certificate(userId, asymmetricKeyPair);
        await registerDevice(userId);

        await storeCertificate(userId, asymmetricKeyPair, x509Pem);
        store.dispatch(SetSetupLoadingAction(false));
      }
    });
  };
}

Future<void> storeCertificate(
    String userId,
    AsymmetricKeyPair<PublicKey, PrivateKey> asymmetricKeyPair,
    String x509Pem) async {
  await _rsaService.storeCertificate(
      userId,
      CertificateStorage(
          privateKeyPEM: _rsaService.getPrivateKeyPEM(asymmetricKeyPair),
          x509PEM: x509Pem));
}

Future<void> registerDevice(String userId) async {
  RegisterDeviceRequestBuilder registerDeviceRequestBuilder =
      RegisterDeviceRequestBuilder();
  registerDeviceRequestBuilder.userId = userId;
  registerDeviceRequestBuilder.deviceHardwareId =
      await _deviceDataService.getDeviceUniqueId();
  await _bpmServiceApiProvider
      .registerDevice(registerDeviceRequestBuilder.build());
}

Future<String> issueX509Certificate(String userId,
    AsymmetricKeyPair<PublicKey, PrivateKey> asymmetricKeyPair) async {
  IssueX509CertificateRequestBuilder x509certificateRequestBuilder =
      IssueX509CertificateRequestBuilder();
  x509certificateRequestBuilder.userId = userId;
  x509certificateRequestBuilder.publicKeyPem =
      _rsaService.getPublicKeyPEM(asymmetricKeyPair);
  String x509Pem = await _bpmServiceApiProvider
      .issueX509Certificate(x509certificateRequestBuilder.build());
  return x509Pem;
}
