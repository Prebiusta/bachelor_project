// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'upload_document_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$UploadDocumentRequest extends UploadDocumentRequest {
  @override
  final String? description;
  @override
  final String? document;

  factory _$UploadDocumentRequest(
          [void Function(UploadDocumentRequestBuilder)? updates]) =>
      (new UploadDocumentRequestBuilder()..update(updates)).build();

  _$UploadDocumentRequest._({this.description, this.document}) : super._();

  @override
  UploadDocumentRequest rebuild(
          void Function(UploadDocumentRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  UploadDocumentRequestBuilder toBuilder() =>
      new UploadDocumentRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is UploadDocumentRequest &&
        description == other.description &&
        document == other.document;
  }

  @override
  int get hashCode {
    return $jf($jc($jc(0, description.hashCode), document.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('UploadDocumentRequest')
          ..add('description', description)
          ..add('document', document))
        .toString();
  }
}

class UploadDocumentRequestBuilder
    implements Builder<UploadDocumentRequest, UploadDocumentRequestBuilder> {
  _$UploadDocumentRequest? _$v;

  String? _description;
  String? get description => _$this._description;
  set description(String? description) => _$this._description = description;

  String? _document;
  String? get document => _$this._document;
  set document(String? document) => _$this._document = document;

  UploadDocumentRequestBuilder() {
    UploadDocumentRequest._defaults(this);
  }

  UploadDocumentRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _description = $v.description;
      _document = $v.document;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(UploadDocumentRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$UploadDocumentRequest;
  }

  @override
  void update(void Function(UploadDocumentRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$UploadDocumentRequest build() {
    final _$result = _$v ??
        new _$UploadDocumentRequest._(
            description: description, document: document);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
