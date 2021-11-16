// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_based_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$UserBasedRequest extends UserBasedRequest {
  @override
  final String? userId;

  factory _$UserBasedRequest(
          [void Function(UserBasedRequestBuilder)? updates]) =>
      (new UserBasedRequestBuilder()..update(updates)).build();

  _$UserBasedRequest._({this.userId}) : super._();

  @override
  UserBasedRequest rebuild(void Function(UserBasedRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  UserBasedRequestBuilder toBuilder() =>
      new UserBasedRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is UserBasedRequest && userId == other.userId;
  }

  @override
  int get hashCode {
    return $jf($jc(0, userId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('UserBasedRequest')
          ..add('userId', userId))
        .toString();
  }
}

class UserBasedRequestBuilder
    implements Builder<UserBasedRequest, UserBasedRequestBuilder> {
  _$UserBasedRequest? _$v;

  String? _userId;
  String? get userId => _$this._userId;
  set userId(String? userId) => _$this._userId = userId;

  UserBasedRequestBuilder() {
    UserBasedRequest._defaults(this);
  }

  UserBasedRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _userId = $v.userId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(UserBasedRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$UserBasedRequest;
  }

  @override
  void update(void Function(UserBasedRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$UserBasedRequest build() {
    final _$result = _$v ?? new _$UserBasedRequest._(userId: userId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
