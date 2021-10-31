// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'task_id_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$TaskIdRequest extends TaskIdRequest {
  @override
  final String? taskId;

  factory _$TaskIdRequest([void Function(TaskIdRequestBuilder)? updates]) =>
      (new TaskIdRequestBuilder()..update(updates)).build();

  _$TaskIdRequest._({this.taskId}) : super._();

  @override
  TaskIdRequest rebuild(void Function(TaskIdRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  TaskIdRequestBuilder toBuilder() => new TaskIdRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is TaskIdRequest && taskId == other.taskId;
  }

  @override
  int get hashCode {
    return $jf($jc(0, taskId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('TaskIdRequest')..add('taskId', taskId))
        .toString();
  }
}

class TaskIdRequestBuilder
    implements Builder<TaskIdRequest, TaskIdRequestBuilder> {
  _$TaskIdRequest? _$v;

  String? _taskId;
  String? get taskId => _$this._taskId;
  set taskId(String? taskId) => _$this._taskId = taskId;

  TaskIdRequestBuilder() {
    TaskIdRequest._defaults(this);
  }

  TaskIdRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _taskId = $v.taskId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(TaskIdRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$TaskIdRequest;
  }

  @override
  void update(void Function(TaskIdRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$TaskIdRequest build() {
    final _$result = _$v ?? new _$TaskIdRequest._(taskId: taskId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
