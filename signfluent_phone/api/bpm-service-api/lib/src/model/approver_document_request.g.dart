// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'approver_document_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$ApproverDocumentRequest extends ApproverDocumentRequest {
  @override
  final bool? approve;
  @override
  final String? processId;

  factory _$ApproverDocumentRequest(
          [void Function(ApproverDocumentRequestBuilder)? updates]) =>
      (new ApproverDocumentRequestBuilder()..update(updates)).build();

  _$ApproverDocumentRequest._({this.approve, this.processId}) : super._();

  @override
  ApproverDocumentRequest rebuild(
          void Function(ApproverDocumentRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  ApproverDocumentRequestBuilder toBuilder() =>
      new ApproverDocumentRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is ApproverDocumentRequest &&
        approve == other.approve &&
        processId == other.processId;
  }

  @override
  int get hashCode {
    return $jf($jc($jc(0, approve.hashCode), processId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('ApproverDocumentRequest')
          ..add('approve', approve)
          ..add('processId', processId))
        .toString();
  }
}

class ApproverDocumentRequestBuilder
    implements
        Builder<ApproverDocumentRequest, ApproverDocumentRequestBuilder> {
  _$ApproverDocumentRequest? _$v;

  bool? _approve;
  bool? get approve => _$this._approve;
  set approve(bool? approve) => _$this._approve = approve;

  String? _processId;
  String? get processId => _$this._processId;
  set processId(String? processId) => _$this._processId = processId;

  ApproverDocumentRequestBuilder() {
    ApproverDocumentRequest._defaults(this);
  }

  ApproverDocumentRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _approve = $v.approve;
      _processId = $v.processId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(ApproverDocumentRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$ApproverDocumentRequest;
  }

  @override
  void update(void Function(ApproverDocumentRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$ApproverDocumentRequest build() {
    final _$result = _$v ??
        new _$ApproverDocumentRequest._(approve: approve, processId: processId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new