//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'user_based_request.g.dart';

/// UserBasedRequest
///
/// Properties:
/// * [userId] 
abstract class UserBasedRequest implements Built<UserBasedRequest, UserBasedRequestBuilder> {
    @BuiltValueField(wireName: r'userId')
    String? get userId;

    UserBasedRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(UserBasedRequestBuilder b) => b;

    factory UserBasedRequest([void updates(UserBasedRequestBuilder b)]) = _$UserBasedRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<UserBasedRequest> get serializer => _$UserBasedRequestSerializer();
}

class _$UserBasedRequestSerializer implements StructuredSerializer<UserBasedRequest> {
    @override
    final Iterable<Type> types = const [UserBasedRequest, _$UserBasedRequest];

    @override
    final String wireName = r'UserBasedRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, UserBasedRequest object,
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
    UserBasedRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = UserBasedRequestBuilder();

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

