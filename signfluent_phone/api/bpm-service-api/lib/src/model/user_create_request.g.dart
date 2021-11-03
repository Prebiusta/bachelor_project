// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_create_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$UserCreateRequest extends UserCreateRequest {
  @override
  final String? email;
  @override
  final String? firstName;
  @override
  final String? lastName;
  @override
  final String? password;
  @override
  final String? username;

  factory _$UserCreateRequest(
          [void Function(UserCreateRequestBuilder)? updates]) =>
      (new UserCreateRequestBuilder()..update(updates)).build();

  _$UserCreateRequest._(
      {this.email, this.firstName, this.lastName, this.password, this.username})
      : super._();

  @override
  UserCreateRequest rebuild(void Function(UserCreateRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  UserCreateRequestBuilder toBuilder() =>
      new UserCreateRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is UserCreateRequest &&
        email == other.email &&
        firstName == other.firstName &&
        lastName == other.lastName &&
        password == other.password &&
        username == other.username;
  }

  @override
  int get hashCode {
    return $jf($jc(
        $jc(
            $jc($jc($jc(0, email.hashCode), firstName.hashCode),
                lastName.hashCode),
            password.hashCode),
        username.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('UserCreateRequest')
          ..add('email', email)
          ..add('firstName', firstName)
          ..add('lastName', lastName)
          ..add('password', password)
          ..add('username', username))
        .toString();
  }
}

class UserCreateRequestBuilder
    implements Builder<UserCreateRequest, UserCreateRequestBuilder> {
  _$UserCreateRequest? _$v;

  String? _email;
  String? get email => _$this._email;
  set email(String? email) => _$this._email = email;

  String? _firstName;
  String? get firstName => _$this._firstName;
  set firstName(String? firstName) => _$this._firstName = firstName;

  String? _lastName;
  String? get lastName => _$this._lastName;
  set lastName(String? lastName) => _$this._lastName = lastName;

  String? _password;
  String? get password => _$this._password;
  set password(String? password) => _$this._password = password;

  String? _username;
  String? get username => _$this._username;
  set username(String? username) => _$this._username = username;

  UserCreateRequestBuilder() {
    UserCreateRequest._defaults(this);
  }

  UserCreateRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _email = $v.email;
      _firstName = $v.firstName;
      _lastName = $v.lastName;
      _password = $v.password;
      _username = $v.username;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(UserCreateRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$UserCreateRequest;
  }

  @override
  void update(void Function(UserCreateRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$UserCreateRequest build() {
    final _$result = _$v ??
        new _$UserCreateRequest._(
            email: email,
            firstName: firstName,
            lastName: lastName,
            password: password,
            username: username);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
