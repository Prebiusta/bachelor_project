// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'signfluent_role_response.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$SignfluentRoleResponse extends SignfluentRoleResponse {
  @override
  final String? key;
  @override
  final String? name;

  factory _$SignfluentRoleResponse(
          [void Function(SignfluentRoleResponseBuilder)? updates]) =>
      (new SignfluentRoleResponseBuilder()..update(updates)).build();

  _$SignfluentRoleResponse._({this.key, this.name}) : super._();

  @override
  SignfluentRoleResponse rebuild(
          void Function(SignfluentRoleResponseBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  SignfluentRoleResponseBuilder toBuilder() =>
      new SignfluentRoleResponseBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is SignfluentRoleResponse &&
        key == other.key &&
        name == other.name;
  }

  @override
  int get hashCode {
    return $jf($jc($jc(0, key.hashCode), name.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('SignfluentRoleResponse')
          ..add('key', key)
          ..add('name', name))
        .toString();
  }
}

class SignfluentRoleResponseBuilder
    implements Builder<SignfluentRoleResponse, SignfluentRoleResponseBuilder> {
  _$SignfluentRoleResponse? _$v;

  String? _key;
  String? get key => _$this._key;
  set key(String? key) => _$this._key = key;

  String? _name;
  String? get name => _$this._name;
  set name(String? name) => _$this._name = name;

  SignfluentRoleResponseBuilder() {
    SignfluentRoleResponse._defaults(this);
  }

  SignfluentRoleResponseBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _key = $v.key;
      _name = $v.name;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(SignfluentRoleResponse other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$SignfluentRoleResponse;
  }

  @override
  void update(void Function(SignfluentRoleResponseBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$SignfluentRoleResponse build() {
    final _$result =
        _$v ?? new _$SignfluentRoleResponse._(key: key, name: name);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
