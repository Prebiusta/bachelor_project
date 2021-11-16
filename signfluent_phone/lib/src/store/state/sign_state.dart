import 'package:business_service_api/business_service_api.dart';
import 'package:flutter/material.dart';

@immutable
class SignState {
  final Future<SignfluentSignatureRequest>? signatureRequest;
  final Future<String>? signingResponse;

  const SignState({
    required this.signatureRequest,
    required this.signingResponse,
  });

  factory SignState.initial() {
    return const SignState(signatureRequest: null, signingResponse: null);
  }

  SignState copyWith(
      {Future<SignfluentSignatureRequest>? signatureRequest,
      Future<String>? signingResponse}) {
    return SignState(
        signatureRequest: signatureRequest, signingResponse: signingResponse);
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is SignState &&
          runtimeType == other.runtimeType &&
          signatureRequest == other.signatureRequest &&
          signingResponse == other.signingResponse;

  @override
  int get hashCode => signatureRequest.hashCode ^ signingResponse.hashCode;
}
