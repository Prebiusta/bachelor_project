//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'authentication_response.g.dart';

/// AuthenticationResponse
///
/// Properties:
/// * [expiresIn] 
/// * [refreshExpiresIn] 
/// * [refreshToken] 
/// * [token] 
/// * [userId] 
abstract class AuthenticationResponse implements Built<AuthenticationResponse, AuthenticationResponseBuilder> {
    @BuiltValueField(wireName: r'expiresIn')
    int? get expiresIn;

    @BuiltValueField(wireName: r'refreshExpiresIn')
    int? get refreshExpiresIn;

    @BuiltValueField(wireName: r'refreshToken')
    String? get refreshToken;

    @BuiltValueField(wireName: r'token')
    String? get token;

    @BuiltValueField(wireName: r'userId')
    String? get userId;

    AuthenticationResponse._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(AuthenticationResponseBuilder b) => b;

    factory AuthenticationResponse([void updates(AuthenticationResponseBuilder b)]) = _$AuthenticationResponse;

    @BuiltValueSerializer(custom: true)
    static Serializer<AuthenticationResponse> get serializer => _$AuthenticationResponseSerializer();
}

class _$AuthenticationResponseSerializer implements StructuredSerializer<AuthenticationResponse> {
    @override
    final Iterable<Type> types = const [AuthenticationResponse, _$AuthenticationResponse];

    @override
    final String wireName = r'AuthenticationResponse';

    @override
    Iterable<Object?> serialize(Serializers serializers, AuthenticationResponse object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.expiresIn != null) {
            result
                ..add(r'expiresIn')
                ..add(serializers.serialize(object.expiresIn,
                    specifiedType: const FullType(int)));
        }
        if (object.refreshExpiresIn != null) {
            result
                ..add(r'refreshExpiresIn')
                ..add(serializers.serialize(object.refreshExpiresIn,
                    specifiedType: const FullType(int)));
        }
        if (object.refreshToken != null) {
            result
                ..add(r'refreshToken')
                ..add(serializers.serialize(object.refreshToken,
                    specifiedType: const FullType(String)));
        }
        if (object.token != null) {
            result
                ..add(r'token')
                ..add(serializers.serialize(object.token,
                    specifiedType: const FullType(String)));
        }
        if (object.userId != null) {
            result
                ..add(r'userId')
                ..add(serializers.serialize(object.userId,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    AuthenticationResponse deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = AuthenticationResponseBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'expiresIn':
                    result.expiresIn = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    break;
                case r'refreshExpiresIn':
                    result.refreshExpiresIn = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    break;
                case r'refreshToken':
                    result.refreshToken = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'token':
                    result.token = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'userId':
                    result.userId = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

