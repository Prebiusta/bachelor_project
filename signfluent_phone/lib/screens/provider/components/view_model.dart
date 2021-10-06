import 'package:redux/redux.dart';
import 'package:signfluent_phone/store/actions/provider_actions.dart';
import 'package:signfluent_phone/store/state/app_sate.dart';

class ProviderViewModel {
  bool isLoading;
  bool isError;
  final String error;
  final Store<AppState> store;

  ProviderViewModel(
      {required this.isLoading,
      required this.isError,
      required this.error,
      required this.store});

  static ProviderViewModel fromStore(Store<AppState> store) {
    return ProviderViewModel(
        isLoading: store.state.providerState.isLoading,
        isError: store.state.providerState.isError,
        error: store.state.providerState.error,
        store: store);
  }

  void pingProvider(baseURL) {
    store.dispatch(verifyProvider(baseURL));
  }
}
