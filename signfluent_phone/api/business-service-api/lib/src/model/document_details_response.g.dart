// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'document_details_response.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$DocumentDetailsResponse extends DocumentDetailsResponse {
  @override
  final BuiltList<ApprovalOrderResponse>? approvalOrder;
  @override
  final String? content;
  @override
  final UserActionResponse? delegatedBy;
  @override
  final String? description;
  @override
  final String? documentId;
  @override
  final String? hash;
  @override
  final UserActionResponse? rejectedBy;
  @override
  final BuiltList<Signature0>? signatures;
  @override
  final String? status;
  @override
  final UserActionResponse? uploadedBy;

  factory _$DocumentDetailsResponse(
          [void Function(DocumentDetailsResponseBuilder)? updates]) =>
      (new DocumentDetailsResponseBuilder()..update(updates)).build();

  _$DocumentDetailsResponse._(
      {this.approvalOrder,
      this.content,
      this.delegatedBy,
      this.description,
      this.documentId,
      this.hash,
      this.rejectedBy,
      this.signatures,
      this.status,
      this.uploadedBy})
      : super._();

  @override
  DocumentDetailsResponse rebuild(
          void Function(DocumentDetailsResponseBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  DocumentDetailsResponseBuilder toBuilder() =>
      new DocumentDetailsResponseBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is DocumentDetailsResponse &&
        approvalOrder == other.approvalOrder &&
        content == other.content &&
        delegatedBy == other.delegatedBy &&
        description == other.description &&
        documentId == other.documentId &&
        hash == other.hash &&
        rejectedBy == other.rejectedBy &&
        signatures == other.signatures &&
        status == other.status &&
        uploadedBy == other.uploadedBy;
  }

  @override
  int get hashCode {
    return $jf($jc(
        $jc(
            $jc(
                $jc(
                    $jc(
                        $jc(
                            $jc(
                                $jc(
                                    $jc($jc(0, approvalOrder.hashCode),
                                        content.hashCode),
                                    delegatedBy.hashCode),
                                description.hashCode),
                            documentId.hashCode),
                        hash.hashCode),
                    rejectedBy.hashCode),
                signatures.hashCode),
            status.hashCode),
        uploadedBy.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('DocumentDetailsResponse')
          ..add('approvalOrder', approvalOrder)
          ..add('content', content)
          ..add('delegatedBy', delegatedBy)
          ..add('description', description)
          ..add('documentId', documentId)
          ..add('hash', hash)
          ..add('rejectedBy', rejectedBy)
          ..add('signatures', signatures)
          ..add('status', status)
          ..add('uploadedBy', uploadedBy))
        .toString();
  }
}

class DocumentDetailsResponseBuilder
    implements
        Builder<DocumentDetailsResponse, DocumentDetailsResponseBuilder> {
  _$DocumentDetailsResponse? _$v;

  ListBuilder<ApprovalOrderResponse>? _approvalOrder;
  ListBuilder<ApprovalOrderResponse> get approvalOrder =>
      _$this._approvalOrder ??= new ListBuilder<ApprovalOrderResponse>();
  set approvalOrder(ListBuilder<ApprovalOrderResponse>? approvalOrder) =>
      _$this._approvalOrder = approvalOrder;

  String? _content;
  String? get content => _$this._content;
  set content(String? content) => _$this._content = content;

  UserActionResponseBuilder? _delegatedBy;
  UserActionResponseBuilder get delegatedBy =>
      _$this._delegatedBy ??= new UserActionResponseBuilder();
  set delegatedBy(UserActionResponseBuilder? delegatedBy) =>
      _$this._delegatedBy = delegatedBy;

  String? _description;
  String? get description => _$this._description;
  set description(String? description) => _$this._description = description;

  String? _documentId;
  String? get documentId => _$this._documentId;
  set documentId(String? documentId) => _$this._documentId = documentId;

  String? _hash;
  String? get hash => _$this._hash;
  set hash(String? hash) => _$this._hash = hash;

  UserActionResponseBuilder? _rejectedBy;
  UserActionResponseBuilder get rejectedBy =>
      _$this._rejectedBy ??= new UserActionResponseBuilder();
  set rejectedBy(UserActionResponseBuilder? rejectedBy) =>
      _$this._rejectedBy = rejectedBy;

  ListBuilder<Signature0>? _signatures;
  ListBuilder<Signature0> get signatures =>
      _$this._signatures ??= new ListBuilder<Signature0>();
  set signatures(ListBuilder<Signature0>? signatures) =>
      _$this._signatures = signatures;

  String? _status;
  String? get status => _$this._status;
  set status(String? status) => _$this._status = status;

  UserActionResponseBuilder? _uploadedBy;
  UserActionResponseBuilder get uploadedBy =>
      _$this._uploadedBy ??= new UserActionResponseBuilder();
  set uploadedBy(UserActionResponseBuilder? uploadedBy) =>
      _$this._uploadedBy = uploadedBy;

  DocumentDetailsResponseBuilder() {
    DocumentDetailsResponse._defaults(this);
  }

  DocumentDetailsResponseBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _approvalOrder = $v.approvalOrder?.toBuilder();
      _content = $v.content;
      _delegatedBy = $v.delegatedBy?.toBuilder();
      _description = $v.description;
      _documentId = $v.documentId;
      _hash = $v.hash;
      _rejectedBy = $v.rejectedBy?.toBuilder();
      _signatures = $v.signatures?.toBuilder();
      _status = $v.status;
      _uploadedBy = $v.uploadedBy?.toBuilder();
      _$v = null;
    }
    return this;
  }

  @override
  void replace(DocumentDetailsResponse other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$DocumentDetailsResponse;
  }

  @override
  void update(void Function(DocumentDetailsResponseBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$DocumentDetailsResponse build() {
    _$DocumentDetailsResponse _$result;
    try {
      _$result = _$v ??
          new _$DocumentDetailsResponse._(
              approvalOrder: _approvalOrder?.build(),
              content: content,
              delegatedBy: _delegatedBy?.build(),
              description: description,
              documentId: documentId,
              hash: hash,
              rejectedBy: _rejectedBy?.build(),
              signatures: _signatures?.build(),
              status: status,
              uploadedBy: _uploadedBy?.build());
    } catch (_) {
      late String _$failedField;
      try {
        _$failedField = 'approvalOrder';
        _approvalOrder?.build();

        _$failedField = 'delegatedBy';
        _delegatedBy?.build();

        _$failedField = 'rejectedBy';
        _rejectedBy?.build();
        _$failedField = 'signatures';
        _signatures?.build();

        _$failedField = 'uploadedBy';
        _uploadedBy?.build();
      } catch (e) {
        throw new BuiltValueNestedFieldError(
            'DocumentDetailsResponse', _$failedField, e.toString());
      }
      rethrow;
    }
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
