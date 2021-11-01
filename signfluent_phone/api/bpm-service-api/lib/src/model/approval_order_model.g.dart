// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'approval_order_model.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$ApprovalOrderModel extends ApprovalOrderModel {
  @override
  final String? approverId;
  @override
  final int? order;

  factory _$ApprovalOrderModel(
          [void Function(ApprovalOrderModelBuilder)? updates]) =>
      (new ApprovalOrderModelBuilder()..update(updates)).build();

  _$ApprovalOrderModel._({this.approverId, this.order}) : super._();

  @override
  ApprovalOrderModel rebuild(
          void Function(ApprovalOrderModelBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  ApprovalOrderModelBuilder toBuilder() =>
      new ApprovalOrderModelBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is ApprovalOrderModel &&
        approverId == other.approverId &&
        order == other.order;
  }

  @override
  int get hashCode {
    return $jf($jc($jc(0, approverId.hashCode), order.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('ApprovalOrderModel')
          ..add('approverId', approverId)
          ..add('order', order))
        .toString();
  }
}

class ApprovalOrderModelBuilder
    implements Builder<ApprovalOrderModel, ApprovalOrderModelBuilder> {
  _$ApprovalOrderModel? _$v;

  String? _approverId;
  String? get approverId => _$this._approverId;
  set approverId(String? approverId) => _$this._approverId = approverId;

  int? _order;
  int? get order => _$this._order;
  set order(int? order) => _$this._order = order;

  ApprovalOrderModelBuilder() {
    ApprovalOrderModel._defaults(this);
  }

  ApprovalOrderModelBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _approverId = $v.approverId;
      _order = $v.order;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(ApprovalOrderModel other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$ApprovalOrderModel;
  }

  @override
  void update(void Function(ApprovalOrderModelBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$ApprovalOrderModel build() {
    final _$result =
        _$v ?? new _$ApprovalOrderModel._(approverId: approverId, order: order);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
