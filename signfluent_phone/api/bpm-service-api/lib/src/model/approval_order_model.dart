//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'approval_order_model.g.dart';

/// ApprovalOrderModel
///
/// Properties:
/// * [approverId] 
/// * [order] 
abstract class ApprovalOrderModel implements Built<ApprovalOrderModel, ApprovalOrderModelBuilder> {
    @BuiltValueField(wireName: r'approverId')
    String? get approverId;

    @BuiltValueField(wireName: r'order')
    int? get order;

    ApprovalOrderModel._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(ApprovalOrderModelBuilder b) => b;

    factory ApprovalOrderModel([void updates(ApprovalOrderModelBuilder b)]) = _$ApprovalOrderModel;

    @BuiltValueSerializer(custom: true)
    static Serializer<ApprovalOrderModel> get serializer => _$ApprovalOrderModelSerializer();
}

class _$ApprovalOrderModelSerializer implements StructuredSerializer<ApprovalOrderModel> {
    @override
    final Iterable<Type> types = const [ApprovalOrderModel, _$ApprovalOrderModel];

    @override
    final String wireName = r'ApprovalOrderModel';

    @override
    Iterable<Object?> serialize(Serializers serializers, ApprovalOrderModel object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.approverId != null) {
            result
                ..add(r'approverId')
                ..add(serializers.serialize(object.approverId,
                    specifiedType: const FullType(String)));
        }
        if (object.order != null) {
            result
                ..add(r'order')
                ..add(serializers.serialize(object.order,
                    specifiedType: const FullType(int)));
        }
        return result;
    }

    @override
    ApprovalOrderModel deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = ApprovalOrderModelBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'approverId':
                    result.approverId = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'order':
                    result.order = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    break;
            }
        }
        return result.build();
    }
}

