import 'package:flutter/material.dart';
import 'package:signfluent_phone/model/signfluent_signature_request.dart';

@immutable
class SignState {
  final bool isLoading;
  final String? error;
  final Future<SignfluentSignatureRequest>? signatureRequest;
  final Future<String>? signingResponse;

  const SignState({
    required this.isLoading,
    required this.error,
    required this.signatureRequest,
    required this.signingResponse,
  });

  factory SignState.initial() {
    return const SignState(
        isLoading: false,
        error: null,
        signatureRequest: null,
        signingResponse: null);
  }

  SignState copyWith(
      {bool? isLoading,
      String? error,
      Future<SignfluentSignatureRequest>? signatureRequest,
      Future<String>? signingResponse}) {
    return SignState(
        isLoading: isLoading ?? this.isLoading,
        error: error ?? this.error,
        signatureRequest: signatureRequest,
        signingResponse: signingResponse);
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is SignState &&
          runtimeType == other.runtimeType &&
          isLoading == other.isLoading &&
          error == other.error &&
          signatureRequest == other.signatureRequest &&
          signingResponse == other.signingResponse;

  @override
  int get hashCode =>
      isLoading.hashCode ^
      error.hashCode ^
      signatureRequest.hashCode ^
      signingResponse.hashCode;
}
