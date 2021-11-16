//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'signfluent_role_response.g.dart';

/// SignfluentRoleResponse
///
/// Properties:
/// * [key] 
/// * [name] 
abstract class SignfluentRoleResponse implements Built<SignfluentRoleResponse, SignfluentRoleResponseBuilder> {
    @BuiltValueField(wireName: r'key')
    String? get key;

    @BuiltValueField(wireName: r'name')
    String? get name;

    SignfluentRoleResponse._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(SignfluentRoleResponseBuilder b) => b;

    factory SignfluentRoleResponse([void updates(SignfluentRoleResponseBuilder b)]) = _$SignfluentRoleResponse;

    @BuiltValueSerializer(custom: true)
    static Serializer<SignfluentRoleResponse> get serializer => _$SignfluentRoleResponseSerializer();
}

class _$SignfluentRoleResponseSerializer implements StructuredSerializer<SignfluentRoleResponse> {
    @override
    final Iterable<Type> types = const [SignfluentRoleResponse, _$SignfluentRoleResponse];

    @override
    final String wireName = r'SignfluentRoleResponse';

    @override
    Iterable<Object?> serialize(Serializers serializers, SignfluentRoleResponse object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.key != null) {
            result
                ..add(r'key')
                ..add(serializers.serialize(object.key,
                    specifiedType: const FullType(String)));
        }
        if (object.name != null) {
            result
                ..add(r'name')
                ..add(serializers.serialize(object.name,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    SignfluentRoleResponse deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SignfluentRoleResponseBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'key':
                    result.key = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'name':
                    result.name = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

