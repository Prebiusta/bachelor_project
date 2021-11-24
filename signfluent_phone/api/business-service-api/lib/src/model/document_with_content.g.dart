// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'document_with_content.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$DocumentWithContent extends DocumentWithContent {
  @override
  final String? content;
  @override
  final String? description;
  @override
  final String? status;
  @override
  final DateTime? uploadedAt;
  @override
  final User0? uploadedBy;

  factory _$DocumentWithContent(
          [void Function(DocumentWithContentBuilder)? updates]) =>
      (new DocumentWithContentBuilder()..update(updates)).build();

  _$DocumentWithContent._(
      {this.content,
      this.description,
      this.status,
      this.uploadedAt,
      this.uploadedBy})
      : super._();

  @override
  DocumentWithContent rebuild(
          void Function(DocumentWithContentBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  DocumentWithContentBuilder toBuilder() =>
      new DocumentWithContentBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is DocumentWithContent &&
        content == other.content &&
        description == other.description &&
        status == other.status &&
        uploadedAt == other.uploadedAt &&
        uploadedBy == other.uploadedBy;
  }

  @override
  int get hashCode {
    return $jf($jc(
        $jc(
            $jc($jc($jc(0, content.hashCode), description.hashCode),
                status.hashCode),
            uploadedAt.hashCode),
        uploadedBy.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('DocumentWithContent')
          ..add('content', content)
          ..add('description', description)
          ..add('status', status)
          ..add('uploadedAt', uploadedAt)
          ..add('uploadedBy', uploadedBy))
        .toString();
  }
}

class DocumentWithContentBuilder
    implements Builder<DocumentWithContent, DocumentWithContentBuilder> {
  _$DocumentWithContent? _$v;

  String? _content;
  String? get content => _$this._content;
  set content(String? content) => _$this._content = content;

  String? _description;
  String? get description => _$this._description;
  set description(String? description) => _$this._description = description;

  String? _status;
  String? get status => _$this._status;
  set status(String? status) => _$this._status = status;

  DateTime? _uploadedAt;
  DateTime? get uploadedAt => _$this._uploadedAt;
  set uploadedAt(DateTime? uploadedAt) => _$this._uploadedAt = uploadedAt;

  User0Builder? _uploadedBy;
  User0Builder get uploadedBy => _$this._uploadedBy ??= new User0Builder();
  set uploadedBy(User0Builder? uploadedBy) => _$this._uploadedBy = uploadedBy;

  DocumentWithContentBuilder() {
    DocumentWithContent._defaults(this);
  }

  DocumentWithContentBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _content = $v.content;
      _description = $v.description;
      _status = $v.status;
      _uploadedAt = $v.uploadedAt;
      _uploadedBy = $v.uploadedBy?.toBuilder();
      _$v = null;
    }
    return this;
  }

  @override
  void replace(DocumentWithContent other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$DocumentWithContent;
  }

  @override
  void update(void Function(DocumentWithContentBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$DocumentWithContent build() {
    _$DocumentWithContent _$result;
    try {
      _$result = _$v ??
          new _$DocumentWithContent._(
              content: content,
              description: description,
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
            'DocumentWithContent', _$failedField, e.toString());
      }
      rethrow;
    }
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
