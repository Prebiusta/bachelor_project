// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'document_response.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$DocumentResponse extends DocumentResponse {
  @override
  final Document? document;
  @override
  final String? processId;

  factory _$DocumentResponse(
          [void Function(DocumentResponseBuilder)? updates]) =>
      (new DocumentResponseBuilder()..update(updates)).build();

  _$DocumentResponse._({this.document, this.processId}) : super._();

  @override
  DocumentResponse rebuild(void Function(DocumentResponseBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  DocumentResponseBuilder toBuilder() =>
      new DocumentResponseBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is DocumentResponse &&
        document == other.document &&
        processId == other.processId;
  }

  @override
  int get hashCode {
    return $jf($jc($jc(0, document.hashCode), processId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('DocumentResponse')
          ..add('document', document)
          ..add('processId', processId))
        .toString();
  }
}

class DocumentResponseBuilder
    implements Builder<DocumentResponse, DocumentResponseBuilder> {
  _$DocumentResponse? _$v;

  DocumentBuilder? _document;
  DocumentBuilder get document => _$this._document ??= new DocumentBuilder();
  set document(DocumentBuilder? document) => _$this._document = document;

  String? _processId;
  String? get processId => _$this._processId;
  set processId(String? processId) => _$this._processId = processId;

  DocumentResponseBuilder() {
    DocumentResponse._defaults(this);
  }

  DocumentResponseBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _document = $v.document?.toBuilder();
      _processId = $v.processId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(DocumentResponse other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$DocumentResponse;
  }

  @override
  void update(void Function(DocumentResponseBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$DocumentResponse build() {
    _$DocumentResponse _$result;
    try {
      _$result = _$v ??
          new _$DocumentResponse._(
              document: _document?.build(), processId: processId);
    } catch (_) {
      late String _$failedField;
      try {
        _$failedField = 'document';
        _document?.build();
      } catch (e) {
        throw new BuiltValueNestedFieldError(
            'DocumentResponse', _$failedField, e.toString());
      }
      rethrow;
    }
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
