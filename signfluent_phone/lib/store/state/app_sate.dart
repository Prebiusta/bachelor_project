import 'package:meta/meta.dart';
import 'package:signfluent_phone/store/state/provider_state.dart';
import 'package:signfluent_phone/store/state/setup_state.dart';
import 'package:signfluent_phone/store/state/sign_state.dart';
import 'package:signfluent_phone/store/state/user_state.dart';

@immutable
class AppState {
  final UserState userState;
  final SetupState setupState;
  final ProviderState providerState;
  final SignState signState;

  const AppState({required this.setupState, required this.userState, required this.providerState, required this.signState});

  AppState copyWith({
    UserState? userState,
    SetupState? setupState,
    ProviderState? providerState,
    SignState? signState,
  }) {
    return AppState(
      userState: userState ?? this.userState,
      setupState: setupState ?? this.setupState,
      providerState: providerState ?? this.providerState,
      signState: signState ?? this.signState,
    );
  }

  factory AppState.initial() {
    return AppState(
      userState: UserState.initial(),
      setupState: SetupState.initial(),
      providerState: ProviderState.initial(),
      signState: SignState.initial(),
    );
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is AppState &&
          runtimeType == other.runtimeType &&
          userState == other.userState &&
          setupState == other.setupState &&
          providerState == other.providerState &&
          signState == other.signState;

  @override
  int get hashCode =>
      userState.hashCode ^
      setupState.hashCode ^
      providerState.hashCode ^
      signState.hashCode;
}
