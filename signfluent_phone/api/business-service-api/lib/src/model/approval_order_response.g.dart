// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'approval_order_response.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$ApprovalOrderResponse extends ApprovalOrderResponse {
  @override
  final int? approvingOrder;
  @override
  final String? id;
  @override
  final User? user;

  factory _$ApprovalOrderResponse(
          [void Function(ApprovalOrderResponseBuilder)? updates]) =>
      (new ApprovalOrderResponseBuilder()..update(updates)).build();

  _$ApprovalOrderResponse._({this.approvingOrder, this.id, this.user})
      : super._();

  @override
  ApprovalOrderResponse rebuild(
          void Function(ApprovalOrderResponseBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  ApprovalOrderResponseBuilder toBuilder() =>
      new ApprovalOrderResponseBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is ApprovalOrderResponse &&
        approvingOrder == other.approvingOrder &&
        id == other.id &&
        user == other.user;
  }

  @override
  int get hashCode {
    return $jf(
        $jc($jc($jc(0, approvingOrder.hashCode), id.hashCode), user.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('ApprovalOrderResponse')
          ..add('approvingOrder', approvingOrder)
          ..add('id', id)
          ..add('user', user))
        .toString();
  }
}

class ApprovalOrderResponseBuilder
    implements Builder<ApprovalOrderResponse, ApprovalOrderResponseBuilder> {
  _$ApprovalOrderResponse? _$v;

  int? _approvingOrder;
  int? get approvingOrder => _$this._approvingOrder;
  set approvingOrder(int? approvingOrder) =>
      _$this._approvingOrder = approvingOrder;

  String? _id;
  String? get id => _$this._id;
  set id(String? id) => _$this._id = id;

  UserBuilder? _user;
  UserBuilder get user => _$this._user ??= new UserBuilder();
  set user(UserBuilder? user) => _$this._user = user;

  ApprovalOrderResponseBuilder() {
    ApprovalOrderResponse._defaults(this);
  }

  ApprovalOrderResponseBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _approvingOrder = $v.approvingOrder;
      _id = $v.id;
      _user = $v.user?.toBuilder();
      _$v = null;
    }
    return this;
  }

  @override
  void replace(ApprovalOrderResponse other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$ApprovalOrderResponse;
  }

  @override
  void update(void Function(ApprovalOrderResponseBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$ApprovalOrderResponse build() {
    _$ApprovalOrderResponse _$result;
    try {
      _$result = _$v ??
          new _$ApprovalOrderResponse._(
              approvingOrder: approvingOrder, id: id, user: _user?.build());
    } catch (_) {
      late String _$failedField;
      try {
        _$failedField = 'user';
        _user?.build();
      } catch (e) {
        throw new BuiltValueNestedFieldError(
            'ApprovalOrderResponse', _$failedField, e.toString());
      }
      rethrow;
    }
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
