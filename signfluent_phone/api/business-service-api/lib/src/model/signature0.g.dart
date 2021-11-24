// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'signature0.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$Signature0 extends Signature0 {
  @override
  final String? certificate;
  @override
  final String? id;
  @override
  final DateTime? signatureDate;
  @override
  final String? signedHash;

  factory _$Signature0([void Function(Signature0Builder)? updates]) =>
      (new Signature0Builder()..update(updates)).build();

  _$Signature0._(
      {this.certificate, this.id, this.signatureDate, this.signedHash})
      : super._();

  @override
  Signature0 rebuild(void Function(Signature0Builder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  Signature0Builder toBuilder() => new Signature0Builder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is Signature0 &&
        certificate == other.certificate &&
        id == other.id &&
        signatureDate == other.signatureDate &&
        signedHash == other.signedHash;
  }

  @override
  int get hashCode {
    return $jf($jc(
        $jc($jc($jc(0, certificate.hashCode), id.hashCode),
            signatureDate.hashCode),
        signedHash.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('Signature0')
          ..add('certificate', certificate)
          ..add('id', id)
          ..add('signatureDate', signatureDate)
          ..add('signedHash', signedHash))
        .toString();
  }
}

class Signature0Builder implements Builder<Signature0, Signature0Builder> {
  _$Signature0? _$v;

  String? _certificate;
  String? get certificate => _$this._certificate;
  set certificate(String? certificate) => _$this._certificate = certificate;

  String? _id;
  String? get id => _$this._id;
  set id(String? id) => _$this._id = id;

  DateTime? _signatureDate;
  DateTime? get signatureDate => _$this._signatureDate;
  set signatureDate(DateTime? signatureDate) =>
      _$this._signatureDate = signatureDate;

  String? _signedHash;
  String? get signedHash => _$this._signedHash;
  set signedHash(String? signedHash) => _$this._signedHash = signedHash;

  Signature0Builder() {
    Signature0._defaults(this);
  }

  Signature0Builder get _$this {
    final $v = _$v;
    if ($v != null) {
      _certificate = $v.certificate;
      _id = $v.id;
      _signatureDate = $v.signatureDate;
      _signedHash = $v.signedHash;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(Signature0 other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$Signature0;
  }

  @override
  void update(void Function(Signature0Builder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$Signature0 build() {
    final _$result = _$v ??
        new _$Signature0._(
            certificate: certificate,
            id: id,
            signatureDate: signatureDate,
            signedHash: signedHash);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
