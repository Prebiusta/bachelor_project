import 'package:redux/redux.dart';
import 'package:signfluent_phone/src/store/actions/actions.dart';
import 'package:signfluent_phone/src/store/state/provider_state.dart';

final providerReducer = combineReducers<ProviderState>([
  TypedReducer<ProviderState, SetProviderLoading>(_setLoading),
  TypedReducer<ProviderState, SetProviderError>(_setError),
  TypedReducer<ProviderState, SetProviderSuccessful>(_setSuccess),
]);

ProviderState _setLoading(ProviderState state, SetProviderLoading action) {
  return state.copyWith(isLoading: action.isLoading, isError: false, error: "");
}

ProviderState _setError(ProviderState state, SetProviderError action) {
  return state.copyWith(isLoading: false, isError: true, error: action.error);
}

ProviderState _setSuccess(ProviderState state, SetProviderSuccessful action) {
  return state.copyWith(isLoading: false, isError: false, error: "");
}
