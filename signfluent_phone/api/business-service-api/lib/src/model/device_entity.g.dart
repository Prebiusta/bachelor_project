// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'device_entity.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$DeviceEntity extends DeviceEntity {
  @override
  final String? deviceHardwareId;
  @override
  final String? fcmtoken;
  @override
  final String? id;
  @override
  final String? userId;

  factory _$DeviceEntity([void Function(DeviceEntityBuilder)? updates]) =>
      (new DeviceEntityBuilder()..update(updates)).build();

  _$DeviceEntity._({this.deviceHardwareId, this.fcmtoken, this.id, this.userId})
      : super._();

  @override
  DeviceEntity rebuild(void Function(DeviceEntityBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  DeviceEntityBuilder toBuilder() => new DeviceEntityBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is DeviceEntity &&
        deviceHardwareId == other.deviceHardwareId &&
        fcmtoken == other.fcmtoken &&
        id == other.id &&
        userId == other.userId;
  }

  @override
  int get hashCode {
    return $jf($jc(
        $jc($jc($jc(0, deviceHardwareId.hashCode), fcmtoken.hashCode),
            id.hashCode),
        userId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('DeviceEntity')
          ..add('deviceHardwareId', deviceHardwareId)
          ..add('fcmtoken', fcmtoken)
          ..add('id', id)
          ..add('userId', userId))
        .toString();
  }
}

class DeviceEntityBuilder
    implements Builder<DeviceEntity, DeviceEntityBuilder> {
  _$DeviceEntity? _$v;

  String? _deviceHardwareId;
  String? get deviceHardwareId => _$this._deviceHardwareId;
  set deviceHardwareId(String? deviceHardwareId) =>
      _$this._deviceHardwareId = deviceHardwareId;

  String? _fcmtoken;
  String? get fcmtoken => _$this._fcmtoken;
  set fcmtoken(String? fcmtoken) => _$this._fcmtoken = fcmtoken;

  String? _id;
  String? get id => _$this._id;
  set id(String? id) => _$this._id = id;

  String? _userId;
  String? get userId => _$this._userId;
  set userId(String? userId) => _$this._userId = userId;

  DeviceEntityBuilder() {
    DeviceEntity._defaults(this);
  }

  DeviceEntityBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _deviceHardwareId = $v.deviceHardwareId;
      _fcmtoken = $v.fcmtoken;
      _id = $v.id;
      _userId = $v.userId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(DeviceEntity other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$DeviceEntity;
  }

  @override
  void update(void Function(DeviceEntityBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$DeviceEntity build() {
    final _$result = _$v ??
        new _$DeviceEntity._(
            deviceHardwareId: deviceHardwareId,
            fcmtoken: fcmtoken,
            id: id,
            userId: userId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
