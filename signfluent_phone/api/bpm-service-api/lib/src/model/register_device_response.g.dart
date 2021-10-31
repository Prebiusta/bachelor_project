// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'register_device_response.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$RegisterDeviceResponse extends RegisterDeviceResponse {
  @override
  final DeviceEntity? deviceEntity;
  @override
  final String? message;
  @override
  final bool? successful;

  factory _$RegisterDeviceResponse(
          [void Function(RegisterDeviceResponseBuilder)? updates]) =>
      (new RegisterDeviceResponseBuilder()..update(updates)).build();

  _$RegisterDeviceResponse._({this.deviceEntity, this.message, this.successful})
      : super._();

  @override
  RegisterDeviceResponse rebuild(
          void Function(RegisterDeviceResponseBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  RegisterDeviceResponseBuilder toBuilder() =>
      new RegisterDeviceResponseBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is RegisterDeviceResponse &&
        deviceEntity == other.deviceEntity &&
        message == other.message &&
        successful == other.successful;
  }

  @override
  int get hashCode {
    return $jf($jc($jc($jc(0, deviceEntity.hashCode), message.hashCode),
        successful.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('RegisterDeviceResponse')
          ..add('deviceEntity', deviceEntity)
          ..add('message', message)
          ..add('successful', successful))
        .toString();
  }
}

class RegisterDeviceResponseBuilder
    implements Builder<RegisterDeviceResponse, RegisterDeviceResponseBuilder> {
  _$RegisterDeviceResponse? _$v;

  DeviceEntityBuilder? _deviceEntity;
  DeviceEntityBuilder get deviceEntity =>
      _$this._deviceEntity ??= new DeviceEntityBuilder();
  set deviceEntity(DeviceEntityBuilder? deviceEntity) =>
      _$this._deviceEntity = deviceEntity;

  String? _message;
  String? get message => _$this._message;
  set message(String? message) => _$this._message = message;

  bool? _successful;
  bool? get successful => _$this._successful;
  set successful(bool? successful) => _$this._successful = successful;

  RegisterDeviceResponseBuilder() {
    RegisterDeviceResponse._defaults(this);
  }

  RegisterDeviceResponseBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _deviceEntity = $v.deviceEntity?.toBuilder();
      _message = $v.message;
      _successful = $v.successful;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(RegisterDeviceResponse other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$RegisterDeviceResponse;
  }

  @override
  void update(void Function(RegisterDeviceResponseBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$RegisterDeviceResponse build() {
    _$RegisterDeviceResponse _$result;
    try {
      _$result = _$v ??
          new _$RegisterDeviceResponse._(
              deviceEntity: _deviceEntity?.build(),
              message: message,
              successful: successful);
    } catch (_) {
      late String _$failedField;
      try {
        _$failedField = 'deviceEntity';
        _deviceEntity?.build();
      } catch (e) {
        throw new BuiltValueNestedFieldError(
            'RegisterDeviceResponse', _$failedField, e.toString());
      }
      rethrow;
    }
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
