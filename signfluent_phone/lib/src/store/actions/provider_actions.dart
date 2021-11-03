import 'package:flutter_redux_navigation/flutter_redux_navigation.dart';
import 'package:redux/redux.dart';
import 'package:redux_thunk/redux_thunk.dart';
import 'package:signfluent_phone/src/provider/bpm_service_api_provider.dart';
import 'package:signfluent_phone/src/routes/routes.dart';
import 'package:signfluent_phone/src/service/api_provider.dart';
import 'package:signfluent_phone/src/service_location.dart';

final BpmServiceApiProvider _bpmServiceApiProvider =
    getIt<BpmServiceApiProvider>();

final ApiProvider _apiProvider = getIt<ApiProvider>();

class SetProviderLoading {
  bool isLoading;

  SetProviderLoading(this.isLoading);
}

class SetProviderSuccessful {}

class SetProviderError {
  String error;

  SetProviderError(this.error);
}

ThunkAction verifyExistingURL() {
  return (Store store) async {
    Future(() async {
      store.dispatch(SetProviderLoading(true));
      _bpmServiceApiProvider
          .ping()
          .then((value) =>
              store.dispatch(NavigateToAction.replace(loginBasePath)))
          .then((value) => store.dispatch(SetProviderLoading(false)))
          .catchError((err) => store.dispatch(SetProviderLoading(false)));
    });
  };
}

ThunkAction verifyProvider(String baseURL) {
  return (Store store) async {
    Future(() async {
      store.dispatch(SetProviderLoading(true));
      await _apiProvider.setBasePath(baseURL);
      _bpmServiceApiProvider.ping().then((value) {
        store.dispatch(SetProviderSuccessful());
        store.dispatch(NavigateToAction.replace(loginBasePath));
      }).catchError((error, stackTrace) =>
          store.dispatch(SetProviderError("Unable to reach provider")));
    });
  };
}
