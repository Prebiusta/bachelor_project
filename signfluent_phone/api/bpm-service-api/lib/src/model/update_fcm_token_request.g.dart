// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'update_fcm_token_request.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$UpdateFCMTokenRequest extends UpdateFCMTokenRequest {
  @override
  final String? deviceHardwareId;
  @override
  final String? fcmToken;
  @override
  final String? userId;

  factory _$UpdateFCMTokenRequest(
          [void Function(UpdateFCMTokenRequestBuilder)? updates]) =>
      (new UpdateFCMTokenRequestBuilder()..update(updates)).build();

  _$UpdateFCMTokenRequest._({this.deviceHardwareId, this.fcmToken, this.userId})
      : super._();

  @override
  UpdateFCMTokenRequest rebuild(
          void Function(UpdateFCMTokenRequestBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  UpdateFCMTokenRequestBuilder toBuilder() =>
      new UpdateFCMTokenRequestBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is UpdateFCMTokenRequest &&
        deviceHardwareId == other.deviceHardwareId &&
        fcmToken == other.fcmToken &&
        userId == other.userId;
  }

  @override
  int get hashCode {
    return $jf($jc($jc($jc(0, deviceHardwareId.hashCode), fcmToken.hashCode),
        userId.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('UpdateFCMTokenRequest')
          ..add('deviceHardwareId', deviceHardwareId)
          ..add('fcmToken', fcmToken)
          ..add('userId', userId))
        .toString();
  }
}

class UpdateFCMTokenRequestBuilder
    implements Builder<UpdateFCMTokenRequest, UpdateFCMTokenRequestBuilder> {
  _$UpdateFCMTokenRequest? _$v;

  String? _deviceHardwareId;
  String? get deviceHardwareId => _$this._deviceHardwareId;
  set deviceHardwareId(String? deviceHardwareId) =>
      _$this._deviceHardwareId = deviceHardwareId;

  String? _fcmToken;
  String? get fcmToken => _$this._fcmToken;
  set fcmToken(String? fcmToken) => _$this._fcmToken = fcmToken;

  String? _userId;
  String? get userId => _$this._userId;
  set userId(String? userId) => _$this._userId = userId;

  UpdateFCMTokenRequestBuilder() {
    UpdateFCMTokenRequest._defaults(this);
  }

  UpdateFCMTokenRequestBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _deviceHardwareId = $v.deviceHardwareId;
      _fcmToken = $v.fcmToken;
      _userId = $v.userId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(UpdateFCMTokenRequest other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$UpdateFCMTokenRequest;
  }

  @override
  void update(void Function(UpdateFCMTokenRequestBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$UpdateFCMTokenRequest build() {
    final _$result = _$v ??
        new _$UpdateFCMTokenRequest._(
            deviceHardwareId: deviceHardwareId,
            fcmToken: fcmToken,
            userId: userId);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
