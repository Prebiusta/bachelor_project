import 'package:flutter_redux_navigation/flutter_redux_navigation.dart';
import 'package:redux/redux.dart';
import 'package:redux_thunk/redux_thunk.dart';
import 'package:signfluent_phone/routes/routes.dart';
import 'package:signfluent_phone/service/api_provider.dart';
import 'package:signfluent_phone/service/user_service.dart';
import 'package:signfluent_phone/service_location.dart';

final UserService _userService = getIt<UserService>();
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
      String? baseURL = await _apiProvider.getBasePath();
      if (baseURL != null) {
        _userService.ping(baseURL).then((bool successful) async {
          if (successful) {
            store.dispatch(NavigateToAction.push(loginBasePath));
          }
          store.dispatch(SetProviderLoading(false));
        }, onError: (_) {
          store.dispatch(SetProviderLoading(false));
        });
      } else {
        store.dispatch(SetProviderLoading(false));
      }
    });
  };
}


ThunkAction verifyProvider(String baseURL) {
  return (Store store) async {
    Future(() async {
      store.dispatch(SetProviderLoading(true));
      _userService.ping(baseURL).then((bool successful) async {
        if (successful) {
          await _apiProvider.setBasePath(baseURL);
          store.dispatch(SetProviderSuccessful());
          store.dispatch(NavigateToAction.push(loginBasePath));
        } else {
          store.dispatch(SetProviderError("Provider responded with wrong message"));
        }
      }, onError: (_) {
        store.dispatch(SetProviderError("Unable to reach provider"));
      });
    });
  };
}
