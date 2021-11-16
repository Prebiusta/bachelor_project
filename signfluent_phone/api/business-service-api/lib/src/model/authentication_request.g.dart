// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'authentication_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$AuthenticationRequest extends AuthenticationRequest {
  @override
  final String? password;
  @override
  final String? username;

  factory _$AuthenticationRequest(
          [void Function(AuthenticationRequestBuilder)? updates]) =>
      (new AuthenticationRequestBuilder()..update(updates)).build();

  _$AuthenticationRequest._({this.password, this.username}) : super._();

  @override
  AuthenticationRequest rebuild(
          void Function(AuthenticationRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  AuthenticationRequestBuilder toBuilder() =>
      new AuthenticationRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is AuthenticationRequest &&
        password == other.password &&
        username == other.username;
  }

  @override
  int get hashCode {
    return $jf($jc($jc(0, password.hashCode), username.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('AuthenticationRequest')
          ..add('password', password)
          ..add('username', username))
        .toString();
  }
}

class AuthenticationRequestBuilder
    implements Builder<AuthenticationRequest, AuthenticationRequestBuilder> {
  _$AuthenticationRequest? _$v;

  String? _password;
  String? get password => _$this._password;
  set password(String? password) => _$this._password = password;

  String? _username;
  String? get username => _$this._username;
  set username(String? username) => _$this._username = username;

  AuthenticationRequestBuilder() {
    AuthenticationRequest._defaults(this);
  }

  AuthenticationRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _password = $v.password;
      _username = $v.username;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(AuthenticationRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$AuthenticationRequest;
  }

  @override
  void update(void Function(AuthenticationRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$AuthenticationRequest build() {
    final _$result = _$v ??
        new _$AuthenticationRequest._(password: password, username: username);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
