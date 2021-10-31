//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'approver_document_request.g.dart';

/// ApproverDocumentRequest
///
/// Properties:
/// * [approve] 
/// * [taskId] 
abstract class ApproverDocumentRequest implements Built<ApproverDocumentRequest, ApproverDocumentRequestBuilder> {
    @BuiltValueField(wireName: r'approve')
    bool? get approve;

    @BuiltValueField(wireName: r'taskId')
    String? get taskId;

    ApproverDocumentRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(ApproverDocumentRequestBuilder b) => b;

    factory ApproverDocumentRequest([void updates(ApproverDocumentRequestBuilder b)]) = _$ApproverDocumentRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<ApproverDocumentRequest> get serializer => _$ApproverDocumentRequestSerializer();
}

class _$ApproverDocumentRequestSerializer implements StructuredSerializer<ApproverDocumentRequest> {
    @override
    final Iterable<Type> types = const [ApproverDocumentRequest, _$ApproverDocumentRequest];

    @override
    final String wireName = r'ApproverDocumentRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, ApproverDocumentRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.approve != null) {
            result
                ..add(r'approve')
                ..add(serializers.serialize(object.approve,
                    specifiedType: const FullType(bool)));
        }
        if (object.taskId != null) {
            result
                ..add(r'taskId')
                ..add(serializers.serialize(object.taskId,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    ApproverDocumentRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = ApproverDocumentRequestBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'approve':
                    result.approve = serializers.deserialize(value,
                        specifiedType: const FullType(bool)) as bool;
                    break;
                case r'taskId':
                    result.taskId = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

