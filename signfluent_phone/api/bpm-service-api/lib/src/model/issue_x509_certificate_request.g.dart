// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'issue_x509_certificate_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$IssueX509CertificateRequest extends IssueX509CertificateRequest {
  @override
  final String? publicKeyPem;
  @override
  final String? userId;

  factory _$IssueX509CertificateRequest(
          [void Function(IssueX509CertificateRequestBuilder)? updates]) =>
      (new IssueX509CertificateRequestBuilder()..update(updates)).build();

  _$IssueX509CertificateRequest._({this.publicKeyPem, this.userId}) : super._();

  @override
  IssueX509CertificateRequest rebuild(
          void Function(IssueX509CertificateRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  IssueX509CertificateRequestBuilder toBuilder() =>
      new IssueX509CertificateRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is IssueX509CertificateRequest &&
        publicKeyPem == other.publicKeyPem &&
        userId == other.userId;
  }

  @override
  int get hashCode {
    return $jf($jc($jc(0, publicKeyPem.hashCode), userId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('IssueX509CertificateRequest')
          ..add('publicKeyPem', publicKeyPem)
          ..add('userId', userId))
        .toString();
  }
}

class IssueX509CertificateRequestBuilder
    implements
        Builder<IssueX509CertificateRequest,
            IssueX509CertificateRequestBuilder> {
  _$IssueX509CertificateRequest? _$v;

  String? _publicKeyPem;
  String? get publicKeyPem => _$this._publicKeyPem;
  set publicKeyPem(String? publicKeyPem) => _$this._publicKeyPem = publicKeyPem;

  String? _userId;
  String? get userId => _$this._userId;
  set userId(String? userId) => _$this._userId = userId;

  IssueX509CertificateRequestBuilder() {
    IssueX509CertificateRequest._defaults(this);
  }

  IssueX509CertificateRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _publicKeyPem = $v.publicKeyPem;
      _userId = $v.userId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(IssueX509CertificateRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$IssueX509CertificateRequest;
  }

  @override
  void update(void Function(IssueX509CertificateRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$IssueX509CertificateRequest build() {
    final _$result = _$v ??
        new _$IssueX509CertificateRequest._(
            publicKeyPem: publicKeyPem, userId: userId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
