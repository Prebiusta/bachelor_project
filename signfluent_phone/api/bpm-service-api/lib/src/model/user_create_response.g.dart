// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_create_response.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$UserCreateResponse extends UserCreateResponse {
  @override
  final String? userId;

  factory _$UserCreateResponse(
          [void Function(UserCreateResponseBuilder)? updates]) =>
      (new UserCreateResponseBuilder()..update(updates)).build();

  _$UserCreateResponse._({this.userId}) : super._();

  @override
  UserCreateResponse rebuild(
          void Function(UserCreateResponseBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  UserCreateResponseBuilder toBuilder() =>
      new UserCreateResponseBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is UserCreateResponse && userId == other.userId;
  }

  @override
  int get hashCode {
    return $jf($jc(0, userId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('UserCreateResponse')
          ..add('userId', userId))
        .toString();
  }
}

class UserCreateResponseBuilder
    implements Builder<UserCreateResponse, UserCreateResponseBuilder> {
  _$UserCreateResponse? _$v;

  String? _userId;
  String? get userId => _$this._userId;
  set userId(String? userId) => _$this._userId = userId;

  UserCreateResponseBuilder() {
    UserCreateResponse._defaults(this);
  }

  UserCreateResponseBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _userId = $v.userId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(UserCreateResponse other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$UserCreateResponse;
  }

  @override
  void update(void Function(UserCreateResponseBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$UserCreateResponse build() {
    final _$result = _$v ?? new _$UserCreateResponse._(userId: userId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
