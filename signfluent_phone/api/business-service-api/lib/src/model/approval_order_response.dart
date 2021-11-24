//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:business_service_api/src/model/user.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'approval_order_response.g.dart';

/// ApprovalOrderResponse
///
/// Properties:
/// * [approvingOrder] 
/// * [id] 
/// * [user] 
abstract class ApprovalOrderResponse implements Built<ApprovalOrderResponse, ApprovalOrderResponseBuilder> {
    @BuiltValueField(wireName: r'approvingOrder')
    int? get approvingOrder;

    @BuiltValueField(wireName: r'id')
    String? get id;

    @BuiltValueField(wireName: r'user')
    User? get user;

    ApprovalOrderResponse._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(ApprovalOrderResponseBuilder b) => b;

    factory ApprovalOrderResponse([void updates(ApprovalOrderResponseBuilder b)]) = _$ApprovalOrderResponse;

    @BuiltValueSerializer(custom: true)
    static Serializer<ApprovalOrderResponse> get serializer => _$ApprovalOrderResponseSerializer();
}

class _$ApprovalOrderResponseSerializer implements StructuredSerializer<ApprovalOrderResponse> {
    @override
    final Iterable<Type> types = const [ApprovalOrderResponse, _$ApprovalOrderResponse];

    @override
    final String wireName = r'ApprovalOrderResponse';

    @override
    Iterable<Object?> serialize(Serializers serializers, ApprovalOrderResponse object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.approvingOrder != null) {
            result
                ..add(r'approvingOrder')
                ..add(serializers.serialize(object.approvingOrder,
                    specifiedType: const FullType(int)));
        }
        if (object.id != null) {
            result
                ..add(r'id')
                ..add(serializers.serialize(object.id,
                    specifiedType: const FullType(String)));
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
    ApprovalOrderResponse deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = ApprovalOrderResponseBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'approvingOrder':
                    result.approvingOrder = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    break;
                case r'id':
                    result.id = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
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

