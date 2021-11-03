// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'register_device_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$RegisterDeviceRequest extends RegisterDeviceRequest {
  @override
  final String? deviceHardwareId;
  @override
  final String? userId;

  factory _$RegisterDeviceRequest(
          [void Function(RegisterDeviceRequestBuilder)? updates]) =>
      (new RegisterDeviceRequestBuilder()..update(updates)).build();

  _$RegisterDeviceRequest._({this.deviceHardwareId, this.userId}) : super._();

  @override
  RegisterDeviceRequest rebuild(
          void Function(RegisterDeviceRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  RegisterDeviceRequestBuilder toBuilder() =>
      new RegisterDeviceRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is RegisterDeviceRequest &&
        deviceHardwareId == other.deviceHardwareId &&
        userId == other.userId;
  }

  @override
  int get hashCode {
    return $jf($jc($jc(0, deviceHardwareId.hashCode), userId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('RegisterDeviceRequest')
          ..add('deviceHardwareId', deviceHardwareId)
          ..add('userId', userId))
        .toString();
  }
}

class RegisterDeviceRequestBuilder
    implements Builder<RegisterDeviceRequest, RegisterDeviceRequestBuilder> {
  _$RegisterDeviceRequest? _$v;

  String? _deviceHardwareId;
  String? get deviceHardwareId => _$this._deviceHardwareId;
  set deviceHardwareId(String? deviceHardwareId) =>
      _$this._deviceHardwareId = deviceHardwareId;

  String? _userId;
  String? get userId => _$this._userId;
  set userId(String? userId) => _$this._userId = userId;

  RegisterDeviceRequestBuilder() {
    RegisterDeviceRequest._defaults(this);
  }

  RegisterDeviceRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _deviceHardwareId = $v.deviceHardwareId;
      _userId = $v.userId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(RegisterDeviceRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$RegisterDeviceRequest;
  }

  @override
  void update(void Function(RegisterDeviceRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$RegisterDeviceRequest build() {
    final _$result = _$v ??
        new _$RegisterDeviceRequest._(
            deviceHardwareId: deviceHardwareId, userId: userId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
