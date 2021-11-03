// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'process_id_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$ProcessIdRequest extends ProcessIdRequest {
  @override
  final String? processId;

  factory _$ProcessIdRequest(
          [void Function(ProcessIdRequestBuilder)? updates]) =>
      (new ProcessIdRequestBuilder()..update(updates)).build();

  _$ProcessIdRequest._({this.processId}) : super._();

  @override
  ProcessIdRequest rebuild(void Function(ProcessIdRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  ProcessIdRequestBuilder toBuilder() =>
      new ProcessIdRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is ProcessIdRequest && processId == other.processId;
  }

  @override
  int get hashCode {
    return $jf($jc(0, processId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('ProcessIdRequest')
          ..add('processId', processId))
        .toString();
  }
}

class ProcessIdRequestBuilder
    implements Builder<ProcessIdRequest, ProcessIdRequestBuilder> {
  _$ProcessIdRequest? _$v;

  String? _processId;
  String? get processId => _$this._processId;
  set processId(String? processId) => _$this._processId = processId;

  ProcessIdRequestBuilder() {
    ProcessIdRequest._defaults(this);
  }

  ProcessIdRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _processId = $v.processId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(ProcessIdRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$ProcessIdRequest;
  }

  @override
  void update(void Function(ProcessIdRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$ProcessIdRequest build() {
    final _$result = _$v ?? new _$ProcessIdRequest._(processId: processId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
