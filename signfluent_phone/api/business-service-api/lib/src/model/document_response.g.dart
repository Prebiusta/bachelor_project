// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'document_response.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$DocumentResponse extends DocumentResponse {
  @override
  final String? description;
  @override
  final String? documentId;
  @override
  final String? status;
  @override
  final DateTime? uploadedAt;
  @override
  final User? uploadedBy;

  factory _$DocumentResponse(
          [void Function(DocumentResponseBuilder)? updates]) =>
      (new DocumentResponseBuilder()..update(updates)).build();

  _$DocumentResponse._(
      {this.description,
      this.documentId,
      this.status,
      this.uploadedAt,
      this.uploadedBy})
      : super._();

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
        description == other.description &&
        documentId == other.documentId &&
        status == other.status &&
        uploadedAt == other.uploadedAt &&
        uploadedBy == other.uploadedBy;
  }

  @override
  int get hashCode {
    return $jf($jc(
        $jc(
            $jc($jc($jc(0, description.hashCode), documentId.hashCode),
                status.hashCode),
            uploadedAt.hashCode),
        uploadedBy.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('DocumentResponse')
          ..add('description', description)
          ..add('documentId', documentId)
          ..add('status', status)
          ..add('uploadedAt', uploadedAt)
          ..add('uploadedBy', uploadedBy))
        .toString();
  }
}

class DocumentResponseBuilder
    implements Builder<DocumentResponse, DocumentResponseBuilder> {
  _$DocumentResponse? _$v;

  String? _description;
  String? get description => _$this._description;
  set description(String? description) => _$this._description = description;

  String? _documentId;
  String? get documentId => _$this._documentId;
  set documentId(String? documentId) => _$this._documentId = documentId;

  String? _status;
  String? get status => _$this._status;
  set status(String? status) => _$this._status = status;

  DateTime? _uploadedAt;
  DateTime? get uploadedAt => _$this._uploadedAt;
  set uploadedAt(DateTime? uploadedAt) => _$this._uploadedAt = uploadedAt;

  UserBuilder? _uploadedBy;
  UserBuilder get uploadedBy => _$this._uploadedBy ??= new UserBuilder();
  set uploadedBy(UserBuilder? uploadedBy) => _$this._uploadedBy = uploadedBy;

  DocumentResponseBuilder() {
    DocumentResponse._defaults(this);
  }

  DocumentResponseBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _description = $v.description;
      _documentId = $v.documentId;
      _status = $v.status;
      _uploadedAt = $v.uploadedAt;
      _uploadedBy = $v.uploadedBy?.toBuilder();
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
              description: description,
              documentId: documentId,
              status: status,
              uploadedAt: uploadedAt,
              uploadedBy: _uploadedBy?.build());
    } catch (_) {
      late String _$failedField;
      try {
        _$failedField = 'uploadedBy';
        _uploadedBy?.build();
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
