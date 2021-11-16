//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'user_create_response.g.dart';

/// UserCreateResponse
///
/// Properties:
/// * [userId] 
abstract class UserCreateResponse implements Built<UserCreateResponse, UserCreateResponseBuilder> {
    @BuiltValueField(wireName: r'userId')
    String? get userId;

    UserCreateResponse._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(UserCreateResponseBuilder b) => b;

    factory UserCreateResponse([void updates(UserCreateResponseBuilder b)]) = _$UserCreateResponse;

    @BuiltValueSerializer(custom: true)
    static Serializer<UserCreateResponse> get serializer => _$UserCreateResponseSerializer();
}

class _$UserCreateResponseSerializer implements StructuredSerializer<UserCreateResponse> {
    @override
    final Iterable<Type> types = const [UserCreateResponse, _$UserCreateResponse];

    @override
    final String wireName = r'UserCreateResponse';

    @override
    Iterable<Object?> serialize(Serializers serializers, UserCreateResponse object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.userId != null) {
            result
                ..add(r'userId')
                ..add(serializers.serialize(object.userId,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    UserCreateResponse deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = UserCreateResponseBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'userId':
                    result.userId = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

