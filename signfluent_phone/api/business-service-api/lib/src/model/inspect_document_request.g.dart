// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'inspect_document_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$InspectDocumentRequest extends InspectDocumentRequest {
  @override
  final String? delegatorId;
  @override
  final bool? isValid;
  @override
  final String? processId;

  factory _$InspectDocumentRequest(
          [void Function(InspectDocumentRequestBuilder)? updates]) =>
      (new InspectDocumentRequestBuilder()..update(updates)).build();

  _$InspectDocumentRequest._({this.delegatorId, this.isValid, this.processId})
      : super._();

  @override
  InspectDocumentRequest rebuild(
          void Function(InspectDocumentRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  InspectDocumentRequestBuilder toBuilder() =>
      new InspectDocumentRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is InspectDocumentRequest &&
        delegatorId == other.delegatorId &&
        isValid == other.isValid &&
        processId == other.processId;
  }

  @override
  int get hashCode {
    return $jf($jc($jc($jc(0, delegatorId.hashCode), isValid.hashCode),
        processId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('InspectDocumentRequest')
          ..add('delegatorId', delegatorId)
          ..add('isValid', isValid)
          ..add('processId', processId))
        .toString();
  }
}

class InspectDocumentRequestBuilder
    implements Builder<InspectDocumentRequest, InspectDocumentRequestBuilder> {
  _$InspectDocumentRequest? _$v;

  String? _delegatorId;
  String? get delegatorId => _$this._delegatorId;
  set delegatorId(String? delegatorId) => _$this._delegatorId = delegatorId;

  bool? _isValid;
  bool? get isValid => _$this._isValid;
  set isValid(bool? isValid) => _$this._isValid = isValid;

  String? _processId;
  String? get processId => _$this._processId;
  set processId(String? processId) => _$this._processId = processId;

  InspectDocumentRequestBuilder() {
    InspectDocumentRequest._defaults(this);
  }

  InspectDocumentRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _delegatorId = $v.delegatorId;
      _isValid = $v.isValid;
      _processId = $v.processId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(InspectDocumentRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$InspectDocumentRequest;
  }

  @override
  void update(void Function(InspectDocumentRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$InspectDocumentRequest build() {
    final _$result = _$v ??
        new _$InspectDocumentRequest._(
            delegatorId: delegatorId, isValid: isValid, processId: processId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
