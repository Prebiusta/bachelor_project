import 'package:flutter/material.dart';

@immutable
class SetupState {
  final bool isLoading;

  const SetupState({
    required this.isLoading,
  });

  factory SetupState.initial() {
    return const SetupState(isLoading: true);
  }

  SetupState copyWith({bool? isLoading}) {
    return SetupState(isLoading: isLoading ?? this.isLoading);
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is SetupState &&
          runtimeType == other.runtimeType &&
          isLoading == other.isLoading;

  @override
  int get hashCode => isLoading.hashCode;
}
