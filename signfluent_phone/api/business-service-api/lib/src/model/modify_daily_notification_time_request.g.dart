// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'modify_daily_notification_time_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$ModifyDailyNotificationTimeRequest
    extends ModifyDailyNotificationTimeRequest {
  @override
  final int? notificationTime;

  factory _$ModifyDailyNotificationTimeRequest(
          [void Function(ModifyDailyNotificationTimeRequestBuilder)?
              updates]) =>
      (new ModifyDailyNotificationTimeRequestBuilder()..update(updates))
          .build();

  _$ModifyDailyNotificationTimeRequest._({this.notificationTime}) : super._();

  @override
  ModifyDailyNotificationTimeRequest rebuild(
          void Function(ModifyDailyNotificationTimeRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  ModifyDailyNotificationTimeRequestBuilder toBuilder() =>
      new ModifyDailyNotificationTimeRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is ModifyDailyNotificationTimeRequest &&
        notificationTime == other.notificationTime;
  }

  @override
  int get hashCode {
    return $jf($jc(0, notificationTime.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('ModifyDailyNotificationTimeRequest')
          ..add('notificationTime', notificationTime))
        .toString();
  }
}

class ModifyDailyNotificationTimeRequestBuilder
    implements
        Builder<ModifyDailyNotificationTimeRequest,
            ModifyDailyNotificationTimeRequestBuilder> {
  _$ModifyDailyNotificationTimeRequest? _$v;

  int? _notificationTime;
  int? get notificationTime => _$this._notificationTime;
  set notificationTime(int? notificationTime) =>
      _$this._notificationTime = notificationTime;

  ModifyDailyNotificationTimeRequestBuilder() {
    ModifyDailyNotificationTimeRequest._defaults(this);
  }

  ModifyDailyNotificationTimeRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _notificationTime = $v.notificationTime;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(ModifyDailyNotificationTimeRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$ModifyDailyNotificationTimeRequest;
  }

  @override
  void update(
      void Function(ModifyDailyNotificationTimeRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$ModifyDailyNotificationTimeRequest build() {
    final _$result = _$v ??
        new _$ModifyDailyNotificationTimeRequest._(
            notificationTime: notificationTime);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
