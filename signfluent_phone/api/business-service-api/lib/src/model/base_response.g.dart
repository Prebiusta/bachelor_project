// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'base_response.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$BaseResponse extends BaseResponse {
  @override
  final String? message;
  @override
  final bool? successful;

  factory _$BaseResponse([void Function(BaseResponseBuilder)? updates]) =>
      (new BaseResponseBuilder()..update(updates)).build();

  _$BaseResponse._({this.message, this.successful}) : super._();

  @override
  BaseResponse rebuild(void Function(BaseResponseBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  BaseResponseBuilder toBuilder() => new BaseResponseBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is BaseResponse &&
        message == other.message &&
        successful == other.successful;
  }

  @override
  int get hashCode {
    return $jf($jc($jc(0, message.hashCode), successful.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('BaseResponse')
          ..add('message', message)
          ..add('successful', successful))
        .toString();
  }
}

class BaseResponseBuilder
    implements Builder<BaseResponse, BaseResponseBuilder> {
  _$BaseResponse? _$v;

  String? _message;
  String? get message => _$this._message;
  set message(String? message) => _$this._message = message;

  bool? _successful;
  bool? get successful => _$this._successful;
  set successful(bool? successful) => _$this._successful = successful;

  BaseResponseBuilder() {
    BaseResponse._defaults(this);
  }

  BaseResponseBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _message = $v.message;
      _successful = $v.successful;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(BaseResponse other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$BaseResponse;
  }

  @override
  void update(void Function(BaseResponseBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$BaseResponse build() {
    final _$result =
        _$v ?? new _$BaseResponse._(message: message, successful: successful);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
