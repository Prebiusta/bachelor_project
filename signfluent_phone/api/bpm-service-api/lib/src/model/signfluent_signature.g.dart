// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'signfluent_signature.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$SignfluentSignature extends SignfluentSignature {
  @override
  final String? signedContent;
  @override
  final String? taskId;
  @override
  final String? x509Pem;

  factory _$SignfluentSignature(
          [void Function(SignfluentSignatureBuilder)? updates]) =>
      (new SignfluentSignatureBuilder()..update(updates)).build();

  _$SignfluentSignature._({this.signedContent, this.taskId, this.x509Pem})
      : super._();

  @override
  SignfluentSignature rebuild(
          void Function(SignfluentSignatureBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  SignfluentSignatureBuilder toBuilder() =>
      new SignfluentSignatureBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is SignfluentSignature &&
        signedContent == other.signedContent &&
        taskId == other.taskId &&
        x509Pem == other.x509Pem;
  }

  @override
  int get hashCode {
    return $jf($jc($jc($jc(0, signedContent.hashCode), taskId.hashCode),
        x509Pem.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('SignfluentSignature')
          ..add('signedContent', signedContent)
          ..add('taskId', taskId)
          ..add('x509Pem', x509Pem))
        .toString();
  }
}

class SignfluentSignatureBuilder
    implements Builder<SignfluentSignature, SignfluentSignatureBuilder> {
  _$SignfluentSignature? _$v;

  String? _signedContent;
  String? get signedContent => _$this._signedContent;
  set signedContent(String? signedContent) =>
      _$this._signedContent = signedContent;

  String? _taskId;
  String? get taskId => _$this._taskId;
  set taskId(String? taskId) => _$this._taskId = taskId;

  String? _x509Pem;
  String? get x509Pem => _$this._x509Pem;
  set x509Pem(String? x509Pem) => _$this._x509Pem = x509Pem;

  SignfluentSignatureBuilder() {
    SignfluentSignature._defaults(this);
  }

  SignfluentSignatureBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _signedContent = $v.signedContent;
      _taskId = $v.taskId;
      _x509Pem = $v.x509Pem;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(SignfluentSignature other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$SignfluentSignature;
  }

  @override
  void update(void Function(SignfluentSignatureBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$SignfluentSignature build() {
    final _$result = _$v ??
        new _$SignfluentSignature._(
            signedContent: signedContent, taskId: taskId, x509Pem: x509Pem);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
