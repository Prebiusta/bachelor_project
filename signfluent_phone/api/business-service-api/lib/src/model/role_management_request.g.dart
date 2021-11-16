// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'role_management_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$RoleManagementRequest extends RoleManagementRequest {
  @override
  final String? role;
  @override
  final String? userId;

  factory _$RoleManagementRequest(
          [void Function(RoleManagementRequestBuilder)? updates]) =>
      (new RoleManagementRequestBuilder()..update(updates)).build();

  _$RoleManagementRequest._({this.role, this.userId}) : super._();

  @override
  RoleManagementRequest rebuild(
          void Function(RoleManagementRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  RoleManagementRequestBuilder toBuilder() =>
      new RoleManagementRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is RoleManagementRequest &&
        role == other.role &&
        userId == other.userId;
  }

  @override
  int get hashCode {
    return $jf($jc($jc(0, role.hashCode), userId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('RoleManagementRequest')
          ..add('role', role)
          ..add('userId', userId))
        .toString();
  }
}

class RoleManagementRequestBuilder
    implements Builder<RoleManagementRequest, RoleManagementRequestBuilder> {
  _$RoleManagementRequest? _$v;

  String? _role;
  String? get role => _$this._role;
  set role(String? role) => _$this._role = role;

  String? _userId;
  String? get userId => _$this._userId;
  set userId(String? userId) => _$this._userId = userId;

  RoleManagementRequestBuilder() {
    RoleManagementRequest._defaults(this);
  }

  RoleManagementRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _role = $v.role;
      _userId = $v.userId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(RoleManagementRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$RoleManagementRequest;
  }

  @override
  void update(void Function(RoleManagementRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$RoleManagementRequest build() {
    final _$result =
        _$v ?? new _$RoleManagementRequest._(role: role, userId: userId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
