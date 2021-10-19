import 'package:signfluent_phone/src/service/api_provider.dart';
import 'package:signfluent_phone/src/service/certificate_authority.dart';
import 'package:signfluent_phone/src/service/device_data_service.dart';
import 'package:signfluent_phone/src/service/rsa_service.dart';
import 'package:get_it/get_it.dart';
import 'package:signfluent_phone/src/service/signature_service.dart';
import 'package:signfluent_phone/src/service/user_service.dart';

final getIt = GetIt.instance;

setupServiceLocator() {
  getIt.registerLazySingleton<ApiProvider>(() => ApiProvider());
  getIt.registerLazySingleton<UserService>(() => UserService());
  getIt.registerLazySingleton<RSAService>(() => RSAService());
  getIt.registerLazySingleton<CertificateAuthorityService>(() => CertificateAuthorityService());
  getIt.registerLazySingleton<DeviceDataService>(() => DeviceDataService());
  getIt.registerLazySingleton<SignatureService>(() => SignatureService());
}