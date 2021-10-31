//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'authentication_request.g.dart';

/// AuthenticationRequest
///
/// Properties:
/// * [password] 
/// * [username] 
abstract class AuthenticationRequest implements Built<AuthenticationRequest, AuthenticationRequestBuilder> {
    @BuiltValueField(wireName: r'password')
    String? get password;

    @BuiltValueField(wireName: r'username')
    String? get username;

    AuthenticationRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(AuthenticationRequestBuilder b) => b;

    factory AuthenticationRequest([void updates(AuthenticationRequestBuilder b)]) = _$AuthenticationRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<AuthenticationRequest> get serializer => _$AuthenticationRequestSerializer();
}

class _$AuthenticationRequestSerializer implements StructuredSerializer<AuthenticationRequest> {
    @override
    final Iterable<Type> types = const [AuthenticationRequest, _$AuthenticationRequest];

    @override
    final String wireName = r'AuthenticationRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, AuthenticationRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.password != null) {
            result
                ..add(r'password')
                ..add(serializers.serialize(object.password,
                    specifiedType: const FullType(String)));
        }
        if (object.username != null) {
            result
                ..add(r'username')
                ..add(serializers.serialize(object.username,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    AuthenticationRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = AuthenticationRequestBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'password':
                    result.password = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'username':
                    result.username = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

