import 'package:flutter_redux_navigation/flutter_redux_navigation.dart';
import 'package:redux/redux.dart';
import 'package:redux_thunk/redux_thunk.dart';
import 'package:signfluent_phone/model/certificate_storage.dart';
import 'package:signfluent_phone/routes/routes.dart';
import 'package:signfluent_phone/service/certificate_authority.dart';
import 'package:signfluent_phone/service/device_data_service.dart';
import 'package:signfluent_phone/service/rsa_service.dart';
import 'package:signfluent_phone/service/user_service.dart';

import '../../service_location.dart';

final UserService _userService = getIt<UserService>();
final RSAService _rsaService = getIt<RSAService>();
final CertificateAuthorityService _certificateAuthorityService =
    getIt<CertificateAuthorityService>();

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
        store.dispatch(NavigateToAction.push(signBasePath));
      } catch (e) {
        var asymmetricKeyPair = await _rsaService.generateKeyPair();

        String x509Pem = await _certificateAuthorityService.issueX509Cert(
            userId, _rsaService.getPublicKeyPEM(asymmetricKeyPair));

        await _userService.registerDevice(
            userId, (await _deviceDataService.getDeviceUniqueId()));

        await _rsaService.storeCertificate(
            userId,
            CertificateStorage(
                privateKeyPEM: _rsaService.getPrivateKeyPEM(asymmetricKeyPair),
                x509PEM: x509Pem));
        store.dispatch(SetSetupLoadingAction(false));
      }
    });
  };
}
