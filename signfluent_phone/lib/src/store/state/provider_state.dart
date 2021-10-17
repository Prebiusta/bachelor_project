import 'package:flutter/material.dart';

@immutable
class ProviderState {
  final bool isLoading;
  final bool isError;
  final String error;

  const ProviderState({
    required this.isLoading,
    required this.error,
    required this.isError,
  });

  factory ProviderState.initial() {
    return const ProviderState(isLoading: false, error: "", isError: false);
  }

  ProviderState copyWith({bool? isLoading, bool? isError, String? error}) {
    return ProviderState(
      isLoading: isLoading ?? this.isLoading,
      error: error ?? this.error,
      isError: isError ?? this.isError,
    );
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is ProviderState &&
          runtimeType == other.runtimeType &&
          isLoading == other.isLoading;

  @override
  int get hashCode => isLoading.hashCode;
}
