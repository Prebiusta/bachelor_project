// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'assign_approvers_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$AssignApproversRequest extends AssignApproversRequest {
  @override
  final BuiltList<ApprovalOrderModel>? approvers;
  @override
  final String? delegatorId;
  @override
  final String? processId;

  factory _$AssignApproversRequest(
          [void Function(AssignApproversRequestBuilder)? updates]) =>
      (new AssignApproversRequestBuilder()..update(updates)).build();

  _$AssignApproversRequest._({this.approvers, this.delegatorId, this.processId})
      : super._();

  @override
  AssignApproversRequest rebuild(
          void Function(AssignApproversRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  AssignApproversRequestBuilder toBuilder() =>
      new AssignApproversRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is AssignApproversRequest &&
        approvers == other.approvers &&
        delegatorId == other.delegatorId &&
        processId == other.processId;
  }

  @override
  int get hashCode {
    return $jf($jc($jc($jc(0, approvers.hashCode), delegatorId.hashCode),
        processId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('AssignApproversRequest')
          ..add('approvers', approvers)
          ..add('delegatorId', delegatorId)
          ..add('processId', processId))
        .toString();
  }
}

class AssignApproversRequestBuilder
    implements Builder<AssignApproversRequest, AssignApproversRequestBuilder> {
  _$AssignApproversRequest? _$v;

  ListBuilder<ApprovalOrderModel>? _approvers;
  ListBuilder<ApprovalOrderModel> get approvers =>
      _$this._approvers ??= new ListBuilder<ApprovalOrderModel>();
  set approvers(ListBuilder<ApprovalOrderModel>? approvers) =>
      _$this._approvers = approvers;

  String? _delegatorId;
  String? get delegatorId => _$this._delegatorId;
  set delegatorId(String? delegatorId) => _$this._delegatorId = delegatorId;

  String? _processId;
  String? get processId => _$this._processId;
  set processId(String? processId) => _$this._processId = processId;

  AssignApproversRequestBuilder() {
    AssignApproversRequest._defaults(this);
  }

  AssignApproversRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _approvers = $v.approvers?.toBuilder();
      _delegatorId = $v.delegatorId;
      _processId = $v.processId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(AssignApproversRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$AssignApproversRequest;
  }

  @override
  void update(void Function(AssignApproversRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$AssignApproversRequest build() {
    _$AssignApproversRequest _$result;
    try {
      _$result = _$v ??
          new _$AssignApproversRequest._(
              approvers: _approvers?.build(),
              delegatorId: delegatorId,
              processId: processId);
    } catch (_) {
      late String _$failedField;
      try {
        _$failedField = 'approvers';
        _approvers?.build();
      } catch (e) {
        throw new BuiltValueNestedFieldError(
            'AssignApproversRequest', _$failedField, e.toString());
      }
      rethrow;
    }
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
