import 'package:signfluent_phone/src/store/reducer/provider_reducer.dart';
import 'package:signfluent_phone/src/store/reducer/setup_reducer.dart';
import 'package:signfluent_phone/src/store/reducer/sign_reducer.dart';
import 'package:signfluent_phone/src/store/reducer/user_reducer.dart';
import 'package:signfluent_phone/src/store/state/app_sate.dart';

AppState appReducer(AppState state, action) {
  return AppState(
    userState: userReducer(state.userState, action),
    setupState: setupReducer(state.setupState, action),
    providerState: providerReducer(state.providerState, action),
    signState: signReducer(state.signState, action),
  );
}
