import 'package:get_it/get_it.dart';
import 'package:signfluent_phone/src/provider/bpm_service_api_provider.dart';
import 'package:signfluent_phone/src/service/api_provider.dart';
import 'package:signfluent_phone/src/service/bearer_token_service.dart';
import 'package:signfluent_phone/src/service/device_data_service.dart';
import 'package:signfluent_phone/src/service/rsa_service.dart';

final getIt = GetIt.instance;

setupServiceLocator() {
  getIt.registerLazySingleton<ApiProvider>(() => ApiProvider());
  getIt.registerLazySingleton<RSAService>(() => RSAService());
  getIt.registerLazySingleton<DeviceDataService>(() => DeviceDataService());
  getIt.registerLazySingleton<BpmServiceApiProvider>(
      () => BpmServiceApiProvider());
  getIt.registerLazySingleton<BearerTokenService>(() => BearerTokenService());
}
