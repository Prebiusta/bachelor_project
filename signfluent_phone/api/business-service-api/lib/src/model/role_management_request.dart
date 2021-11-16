//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'role_management_request.g.dart';

/// RoleManagementRequest
///
/// Properties:
/// * [role] 
/// * [userId] 
abstract class RoleManagementRequest implements Built<RoleManagementRequest, RoleManagementRequestBuilder> {
    @BuiltValueField(wireName: r'role')
    String? get role;

    @BuiltValueField(wireName: r'userId')
    String? get userId;

    RoleManagementRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(RoleManagementRequestBuilder b) => b;

    factory RoleManagementRequest([void updates(RoleManagementRequestBuilder b)]) = _$RoleManagementRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<RoleManagementRequest> get serializer => _$RoleManagementRequestSerializer();
}

class _$RoleManagementRequestSerializer implements StructuredSerializer<RoleManagementRequest> {
    @override
    final Iterable<Type> types = const [RoleManagementRequest, _$RoleManagementRequest];

    @override
    final String wireName = r'RoleManagementRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, RoleManagementRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.role != null) {
            result
                ..add(r'role')
                ..add(serializers.serialize(object.role,
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
    RoleManagementRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = RoleManagementRequestBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'role':
                    result.role = serializers.deserialize(value,
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

