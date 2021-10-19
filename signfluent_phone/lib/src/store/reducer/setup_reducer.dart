import 'package:redux/redux.dart';
import 'package:signfluent_phone/src/store/actions/actions.dart';
import 'package:signfluent_phone/src/store/state/setup_state.dart';
import 'package:signfluent_phone/src/store/state/user_state.dart';

final setupReducer = combineReducers<SetupState>([
  TypedReducer<SetupState, SetSetupLoadingAction>(_setLoading),
]);

SetupState _setLoading(SetupState state, SetSetupLoadingAction action) {
  return state.copyWith(isLoading: action.isLoading);
}
