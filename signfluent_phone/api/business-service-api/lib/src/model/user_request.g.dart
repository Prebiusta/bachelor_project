// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$UserRequest extends UserRequest {
  @override
  final String? userId;

  factory _$UserRequest([void Function(UserRequestBuilder)? updates]) =>
      (new UserRequestBuilder()..update(updates)).build();

  _$UserRequest._({this.userId}) : super._();

  @override
  UserRequest rebuild(void Function(UserRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  UserRequestBuilder toBuilder() => new UserRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is UserRequest && userId == other.userId;
  }

  @override
  int get hashCode {
    return $jf($jc(0, userId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('UserRequest')..add('userId', userId))
        .toString();
  }
}

class UserRequestBuilder implements Builder<UserRequest, UserRequestBuilder> {
  _$UserRequest? _$v;

  String? _userId;
  String? get userId => _$this._userId;
  set userId(String? userId) => _$this._userId = userId;

  UserRequestBuilder() {
    UserRequest._defaults(this);
  }

  UserRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _userId = $v.userId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(UserRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$UserRequest;
  }

  @override
  void update(void Function(UserRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$UserRequest build() {
    final _$result = _$v ?? new _$UserRequest._(userId: userId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
