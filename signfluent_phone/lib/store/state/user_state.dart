import 'package:flutter/material.dart';
import 'package:signfluent_phone/model/authentication_response.dart';

@immutable
class UserState {
  final bool isLoading;
  final bool loginError;
  final AuthenticateResponse? authenticationResponse;

  const UserState({
    required this.isLoading,
    required this.loginError,
    required this.authenticationResponse,
  });

  factory UserState.initial() {
    return const UserState(
        isLoading: false, loginError: false, authenticationResponse: null);
  }

  UserState copyWith(
      {bool? isLoading,
      bool? loginError,
      AuthenticateResponse? authenticationResponse}) {
    return UserState(
        isLoading: isLoading ?? this.isLoading,
        loginError: loginError ?? this.loginError,
        authenticationResponse:
            authenticationResponse ?? this.authenticationResponse);
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is UserState &&
          runtimeType == other.runtimeType &&
          isLoading == other.isLoading &&
          loginError == other.loginError &&
          authenticationResponse == other.authenticationResponse;

  @override
  int get hashCode =>
      isLoading.hashCode ^
      loginError.hashCode ^
      authenticationResponse.hashCode;
}
