//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_collection/built_collection.dart';
import 'package:bpm_service_api/src/model/approval_order_model.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'assign_approvers_request.g.dart';

/// AssignApproversRequest
///
/// Properties:
/// * [approvers] 
/// * [processId] 
abstract class AssignApproversRequest implements Built<AssignApproversRequest, AssignApproversRequestBuilder> {
    @BuiltValueField(wireName: r'approvers')
    BuiltList<ApprovalOrderModel>? get approvers;

    @BuiltValueField(wireName: r'processId')
    String? get processId;

    AssignApproversRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(AssignApproversRequestBuilder b) => b;

    factory AssignApproversRequest([void updates(AssignApproversRequestBuilder b)]) = _$AssignApproversRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<AssignApproversRequest> get serializer => _$AssignApproversRequestSerializer();
}

class _$AssignApproversRequestSerializer implements StructuredSerializer<AssignApproversRequest> {
    @override
    final Iterable<Type> types = const [AssignApproversRequest, _$AssignApproversRequest];

    @override
    final String wireName = r'AssignApproversRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, AssignApproversRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.approvers != null) {
            result
                ..add(r'approvers')
                ..add(serializers.serialize(object.approvers,
                    specifiedType: const FullType(BuiltList, [FullType(ApprovalOrderModel)])));
        }
        if (object.processId != null) {
            result
                ..add(r'processId')
                ..add(serializers.serialize(object.processId,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    AssignApproversRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = AssignApproversRequestBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'approvers':
                    result.approvers.replace(serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(ApprovalOrderModel)])) as BuiltList<ApprovalOrderModel>);
                    break;
                case r'processId':
                    result.processId = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

