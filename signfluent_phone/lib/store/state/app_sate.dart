import 'package:meta/meta.dart';
import 'package:signfluent_phone/store/state/provider_state.dart';
import 'package:signfluent_phone/store/state/setup_state.dart';
import 'package:signfluent_phone/store/state/user_state.dart';

@immutable
class AppState {
  final UserState userState;
  final SetupState setupState;
  final ProviderState providerState;

  const AppState({required this.setupState, required this.userState, required this.providerState});

  AppState copyWith({
    UserState? userState,
    SetupState? setupState,
    ProviderState? providerState,
  }) {
    return AppState(
      userState: userState ?? this.userState,
      setupState: setupState ?? this.setupState,
      providerState: providerState ?? this.providerState,
    );
  }

  factory AppState.initial() {
    return AppState(
      userState: UserState.initial(),
      setupState: SetupState.initial(),
      providerState: ProviderState.initial(),
    );
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is AppState &&
          runtimeType == other.runtimeType &&
          userState == other.userState &&
          setupState == other.setupState;

  @override
  int get hashCode => userState.hashCode ^ setupState.hashCode;
}
