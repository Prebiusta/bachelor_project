import 'package:business_service_api/business_service_api.dart';
import 'package:flutter/material.dart';

@immutable
class UserState {
  final bool isLoading;
  final bool loginError;
  final String? token;
  final AuthenticationResponse? authenticationResponse;

  const UserState({
    required this.isLoading,
    required this.loginError,
    required this.token,
    required this.authenticationResponse,
  });

  factory UserState.initial() {
    return const UserState(
        isLoading: false,
        loginError: false,
        token: null,
        authenticationResponse: null);
  }

  UserState copyWith(
      {bool? isLoading,
      bool? loginError,
      String? token,
      AuthenticationResponse? authenticationResponse}) {
    return UserState(
        isLoading: isLoading ?? this.isLoading,
        loginError: loginError ?? this.loginError,
        token: token ?? this.token,
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
          token == other.token &&
          authenticationResponse == other.authenticationResponse;

  @override
  int get hashCode =>
      isLoading.hashCode ^
      loginError.hashCode ^
      token.hashCode ^
      authenticationResponse.hashCode;
}
