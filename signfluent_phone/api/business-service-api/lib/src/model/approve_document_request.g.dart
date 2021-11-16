// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'approve_document_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$ApproveDocumentRequest extends ApproveDocumentRequest {
  @override
  final bool? approve;
  @override
  final String? approverId;
  @override
  final String? processId;

  factory _$ApproveDocumentRequest(
          [void Function(ApproveDocumentRequestBuilder)? updates]) =>
      (new ApproveDocumentRequestBuilder()..update(updates)).build();

  _$ApproveDocumentRequest._({this.approve, this.approverId, this.processId})
      : super._();

  @override
  ApproveDocumentRequest rebuild(
          void Function(ApproveDocumentRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  ApproveDocumentRequestBuilder toBuilder() =>
      new ApproveDocumentRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is ApproveDocumentRequest &&
        approve == other.approve &&
        approverId == other.approverId &&
        processId == other.processId;
  }

  @override
  int get hashCode {
    return $jf($jc($jc($jc(0, approve.hashCode), approverId.hashCode),
        processId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('ApproveDocumentRequest')
          ..add('approve', approve)
          ..add('approverId', approverId)
          ..add('processId', processId))
        .toString();
  }
}

class ApproveDocumentRequestBuilder
    implements Builder<ApproveDocumentRequest, ApproveDocumentRequestBuilder> {
  _$ApproveDocumentRequest? _$v;

  bool? _approve;
  bool? get approve => _$this._approve;
  set approve(bool? approve) => _$this._approve = approve;

  String? _approverId;
  String? get approverId => _$this._approverId;
  set approverId(String? approverId) => _$this._approverId = approverId;

  String? _processId;
  String? get processId => _$this._processId;
  set processId(String? processId) => _$this._processId = processId;

  ApproveDocumentRequestBuilder() {
    ApproveDocumentRequest._defaults(this);
  }

  ApproveDocumentRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _approve = $v.approve;
      _approverId = $v.approverId;
      _processId = $v.processId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(ApproveDocumentRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$ApproveDocumentRequest;
  }

  @override
  void update(void Function(ApproveDocumentRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$ApproveDocumentRequest build() {
    final _$result = _$v ??
        new _$ApproveDocumentRequest._(
            approve: approve, approverId: approverId, processId: processId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
