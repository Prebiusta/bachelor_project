// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'document_with_process_response.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$DocumentWithProcessResponse extends DocumentWithProcessResponse {
  @override
  final DocumentResponse? document;
  @override
  final String? processId;

  factory _$DocumentWithProcessResponse(
          [void Function(DocumentWithProcessResponseBuilder)? updates]) =>
      (new DocumentWithProcessResponseBuilder()..update(updates)).build();

  _$DocumentWithProcessResponse._({this.document, this.processId}) : super._();

  @override
  DocumentWithProcessResponse rebuild(
          void Function(DocumentWithProcessResponseBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  DocumentWithProcessResponseBuilder toBuilder() =>
      new DocumentWithProcessResponseBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is DocumentWithProcessResponse &&
        document == other.document &&
        processId == other.processId;
  }

  @override
  int get hashCode {
    return $jf($jc($jc(0, document.hashCode), processId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('DocumentWithProcessResponse')
          ..add('document', document)
          ..add('processId', processId))
        .toString();
  }
}

class DocumentWithProcessResponseBuilder
    implements
        Builder<DocumentWithProcessResponse,
            DocumentWithProcessResponseBuilder> {
  _$DocumentWithProcessResponse? _$v;

  DocumentResponseBuilder? _document;
  DocumentResponseBuilder get document =>
      _$this._document ??= new DocumentResponseBuilder();
  set document(DocumentResponseBuilder? document) =>
      _$this._document = document;

  String? _processId;
  String? get processId => _$this._processId;
  set processId(String? processId) => _$this._processId = processId;

  DocumentWithProcessResponseBuilder() {
    DocumentWithProcessResponse._defaults(this);
  }

  DocumentWithProcessResponseBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _document = $v.document?.toBuilder();
      _processId = $v.processId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(DocumentWithProcessResponse other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$DocumentWithProcessResponse;
  }

  @override
  void update(void Function(DocumentWithProcessResponseBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$DocumentWithProcessResponse build() {
    _$DocumentWithProcessResponse _$result;
    try {
      _$result = _$v ??
          new _$DocumentWithProcessResponse._(
              document: _document?.build(), processId: processId);
    } catch (_) {
      late String _$failedField;
      try {
        _$failedField = 'document';
        _document?.build();
      } catch (e) {
        throw new BuiltValueNestedFieldError(
            'DocumentWithProcessResponse', _$failedField, e.toString());
      }
      rethrow;
    }
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
