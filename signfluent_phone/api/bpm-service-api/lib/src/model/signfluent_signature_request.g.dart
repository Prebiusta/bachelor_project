// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'signfluent_signature_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$SignfluentSignatureRequest extends SignfluentSignatureRequest {
  @override
  final String? contentToBeSigned;
  @override
  final String? taskId;

  factory _$SignfluentSignatureRequest(
          [void Function(SignfluentSignatureRequestBuilder)? updates]) =>
      (new SignfluentSignatureRequestBuilder()..update(updates)).build();

  _$SignfluentSignatureRequest._({this.contentToBeSigned, this.taskId})
      : super._();

  @override
  SignfluentSignatureRequest rebuild(
          void Function(SignfluentSignatureRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  SignfluentSignatureRequestBuilder toBuilder() =>
      new SignfluentSignatureRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is SignfluentSignatureRequest &&
        contentToBeSigned == other.contentToBeSigned &&
        taskId == other.taskId;
  }

  @override
  int get hashCode {
    return $jf($jc($jc(0, contentToBeSigned.hashCode), taskId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('SignfluentSignatureRequest')
          ..add('contentToBeSigned', contentToBeSigned)
          ..add('taskId', taskId))
        .toString();
  }
}

class SignfluentSignatureRequestBuilder
    implements
        Builder<SignfluentSignatureRequest, SignfluentSignatureRequestBuilder> {
  _$SignfluentSignatureRequest? _$v;

  String? _contentToBeSigned;
  String? get contentToBeSigned => _$this._contentToBeSigned;
  set contentToBeSigned(String? contentToBeSigned) =>
      _$this._contentToBeSigned = contentToBeSigned;

  String? _taskId;
  String? get taskId => _$this._taskId;
  set taskId(String? taskId) => _$this._taskId = taskId;

  SignfluentSignatureRequestBuilder() {
    SignfluentSignatureRequest._defaults(this);
  }

  SignfluentSignatureRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _contentToBeSigned = $v.contentToBeSigned;
      _taskId = $v.taskId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(SignfluentSignatureRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$SignfluentSignatureRequest;
  }

  @override
  void update(void Function(SignfluentSignatureRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$SignfluentSignatureRequest build() {
    final _$result = _$v ??
        new _$SignfluentSignatureRequest._(
            contentToBeSigned: contentToBeSigned, taskId: taskId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
