import 'package:flutter_redux_navigation/flutter_redux_navigation.dart';
import 'package:redux/redux.dart';
import 'package:signfluent_phone/src/routes/routes.dart';
import 'package:signfluent_phone/src/store/state/app_sate.dart';

class SetupViewModel {
  bool isLoading = true;
  final String userId;
  final String deviceId;
  final Store<AppState> store;

  SetupViewModel(
      {required this.isLoading,
      required this.userId,
      required this.deviceId,
      required this.store});

  static SetupViewModel fromStore(Store<AppState> store) {
    return SetupViewModel(
        isLoading: store.state.setupState.isLoading,
        userId: store.state.userState.authenticationResponse!.userId!,
        deviceId: "123456",
        //TODO: Extract device ID from hardware
        store: store);
  }

  void navigateToSignView() {
    store.dispatch(NavigateToAction.replace(signBasePath));
  }
}
