// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_dto.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$UserDTO extends UserDTO {
  @override
  final String? email;
  @override
  final String? firstName;
  @override
  final String? id;
  @override
  final String? lastName;
  @override
  final String? username;

  factory _$UserDTO([void Function(UserDTOBuilder)? updates]) =>
      (new UserDTOBuilder()..update(updates)).build();

  _$UserDTO._(
      {this.email, this.firstName, this.id, this.lastName, this.username})
      : super._();

  @override
  UserDTO rebuild(void Function(UserDTOBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  UserDTOBuilder toBuilder() => new UserDTOBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is UserDTO &&
        email == other.email &&
        firstName == other.firstName &&
        id == other.id &&
        lastName == other.lastName &&
        username == other.username;
  }

  @override
  int get hashCode {
    return $jf($jc(
        $jc($jc($jc($jc(0, email.hashCode), firstName.hashCode), id.hashCode),
            lastName.hashCode),
        username.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('UserDTO')
          ..add('email', email)
          ..add('firstName', firstName)
          ..add('id', id)
          ..add('lastName', lastName)
          ..add('username', username))
        .toString();
  }
}

class UserDTOBuilder implements Builder<UserDTO, UserDTOBuilder> {
  _$UserDTO? _$v;

  String? _email;
  String? get email => _$this._email;
  set email(String? email) => _$this._email = email;

  String? _firstName;
  String? get firstName => _$this._firstName;
  set firstName(String? firstName) => _$this._firstName = firstName;

  String? _id;
  String? get id => _$this._id;
  set id(String? id) => _$this._id = id;

  String? _lastName;
  String? get lastName => _$this._lastName;
  set lastName(String? lastName) => _$this._lastName = lastName;

  String? _username;
  String? get username => _$this._username;
  set username(String? username) => _$this._username = username;

  UserDTOBuilder() {
    UserDTO._defaults(this);
  }

  UserDTOBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _email = $v.email;
      _firstName = $v.firstName;
      _id = $v.id;
      _lastName = $v.lastName;
      _username = $v.username;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(UserDTO other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$UserDTO;
  }

  @override
  void update(void Function(UserDTOBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$UserDTO build() {
    final _$result = _$v ??
        new _$UserDTO._(
            email: email,
            firstName: firstName,
            id: id,
            lastName: lastName,
            username: username);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
