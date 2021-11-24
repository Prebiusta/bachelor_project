// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_action_response.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$UserActionResponse extends UserActionResponse {
  @override
  final DateTime? date;
  @override
  final User? user;

  factory _$UserActionResponse(
          [void Function(UserActionResponseBuilder)? updates]) =>
      (new UserActionResponseBuilder()..update(updates)).build();

  _$UserActionResponse._({this.date, this.user}) : super._();

  @override
  UserActionResponse rebuild(
          void Function(UserActionResponseBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  UserActionResponseBuilder toBuilder() =>
      new UserActionResponseBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is UserActionResponse &&
        date == other.date &&
        user == other.user;
  }

  @override
  int get hashCode {
    return $jf($jc($jc(0, date.hashCode), user.hashCode));
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper('UserActionResponse')
          ..add('date', date)
          ..add('user', user))
        .toString();
  }
}

class UserActionResponseBuilder
    implements Builder<UserActionResponse, UserActionResponseBuilder> {
  _$UserActionResponse? _$v;

  DateTime? _date;
  DateTime? get date => _$this._date;
  set date(DateTime? date) => _$this._date = date;

  UserBuilder? _user;
  UserBuilder get user => _$this._user ??= new UserBuilder();
  set user(UserBuilder? user) => _$this._user = user;

  UserActionResponseBuilder() {
    UserActionResponse._defaults(this);
  }

  UserActionResponseBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _date = $v.date;
      _user = $v.user?.toBuilder();
      _$v = null;
    }
    return this;
  }

  @override
  void replace(UserActionResponse other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$UserActionResponse;
  }

  @override
  void update(void Function(UserActionResponseBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  _$UserActionResponse build() {
    _$UserActionResponse _$result;
    try {
      _$result =
          _$v ?? new _$UserActionResponse._(date: date, user: _user?.build());
    } catch (_) {
      late String _$failedField;
      try {
        _$failedField = 'user';
        _user?.build();
      } catch (e) {
        throw new BuiltValueNestedFieldError(
            'UserActionResponse', _$failedField, e.toString());
      }
      rethrow;
    }
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: always_put_control_body_on_new_line,always_specify_types,annotate_overrides,avoid_annotating_with_dynamic,avoid_as,avoid_catches_without_on_clauses,avoid_returning_this,deprecated_member_use_from_same_package,lines_longer_than_80_chars,omit_local_variable_types,prefer_expression_function_bodies,sort_constructors_first,test_types_in_equals,unnecessary_const,unnecessary_new
