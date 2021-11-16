// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'update_fcm_token_response.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$UpdateFCMTokenResponse extends UpdateFCMTokenResponse {
  @override
  final DeviceEntity? deviceEntity;
  @override
  final String? message;
  @override
  final bool? successful;

  factory _$UpdateFCMTokenResponse(
          [void Function(UpdateFCMTokenResponseBuilder)? updates]) =>
      (new UpdateFCMTokenResponseBuilder()..update(updates)).build();

  _$UpdateFCMTokenResponse._({this.deviceEntity, this.message, this.successful})
      : super._();

  @override
  UpdateFCMTokenResponse rebuild(
          void Function(UpdateFCMTokenResponseBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  UpdateFCMTokenResponseBuilder toBuilder() =>
      new UpdateFCMTokenResponseBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is UpdateFCMTokenResponse &&
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
    return (newBuiltValueToStringHelper('UpdateFCMTokenResponse')
          ..add('deviceEntity', deviceEntity)
          ..add('message', message)
          ..add('successful', successful))
        .toString();
  }
}

class UpdateFCMTokenResponseBuilder
    implements Builder<UpdateFCMTokenResponse, UpdateFCMTokenResponseBuilder> {
  _$UpdateFCMTokenResponse? _$v;

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

  UpdateFCMTokenResponseBuilder() {
    UpdateFCMTokenResponse._defaults(this);
  }

  UpdateFCMTokenResponseBuilder get _$this {
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
  void replace(UpdateFCMTokenResponse other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$UpdateFCMTokenResponse;
  }

  @override
  void update(void Function(UpdateFCMTokenResponseBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$UpdateFCMTokenResponse build() {
    _$UpdateFCMTokenResponse _$result;
    try {
      _$result = _$v ??
          new _$UpdateFCMTokenResponse._(
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
            'UpdateFCMTokenResponse', _$failedField, e.toString());
      }
      rethrow;
    }
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
