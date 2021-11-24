//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:business_service_api/src/model/user.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'user_action_response.g.dart';

/// UserActionResponse
///
/// Properties:
/// * [date] 
/// * [user] 
abstract class UserActionResponse implements Built<UserActionResponse, UserActionResponseBuilder> {
    @BuiltValueField(wireName: r'date')
    DateTime? get date;

    @BuiltValueField(wireName: r'user')
    User? get user;

    UserActionResponse._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(UserActionResponseBuilder b) => b;

    factory UserActionResponse([void updates(UserActionResponseBuilder b)]) = _$UserActionResponse;

    @BuiltValueSerializer(custom: true)
    static Serializer<UserActionResponse> get serializer => _$UserActionResponseSerializer();
}

class _$UserActionResponseSerializer implements StructuredSerializer<UserActionResponse> {
    @override
    final Iterable<Type> types = const [UserActionResponse, _$UserActionResponse];

    @override
    final String wireName = r'UserActionResponse';

    @override
    Iterable<Object?> serialize(Serializers serializers, UserActionResponse object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.date != null) {
            result
                ..add(r'date')
                ..add(serializers.serialize(object.date,
                    specifiedType: const FullType(DateTime)));
        }
        if (object.user != null) {
            result
                ..add(r'user')
                ..add(serializers.serialize(object.user,
                    specifiedType: const FullType(User)));
        }
        return result;
    }

    @override
    UserActionResponse deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = UserActionResponseBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'date':
                    result.date = serializers.deserialize(value,
                        specifiedType: const FullType(DateTime)) as DateTime;
                    break;
                case r'user':
                    result.user.replace(serializers.deserialize(value,
                        specifiedType: const FullType(User)) as User);
                    break;
            }
        }
        return result.build();
    }
}

