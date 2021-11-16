//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'approve_document_request.g.dart';

/// ApproveDocumentRequest
///
/// Properties:
/// * [approve] 
/// * [approverId] 
/// * [processId] 
abstract class ApproveDocumentRequest implements Built<ApproveDocumentRequest, ApproveDocumentRequestBuilder> {
    @BuiltValueField(wireName: r'approve')
    bool? get approve;

    @BuiltValueField(wireName: r'approverId')
    String? get approverId;

    @BuiltValueField(wireName: r'processId')
    String? get processId;

    ApproveDocumentRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(ApproveDocumentRequestBuilder b) => b;

    factory ApproveDocumentRequest([void updates(ApproveDocumentRequestBuilder b)]) = _$ApproveDocumentRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<ApproveDocumentRequest> get serializer => _$ApproveDocumentRequestSerializer();
}

class _$ApproveDocumentRequestSerializer implements StructuredSerializer<ApproveDocumentRequest> {
    @override
    final Iterable<Type> types = const [ApproveDocumentRequest, _$ApproveDocumentRequest];

    @override
    final String wireName = r'ApproveDocumentRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, ApproveDocumentRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.approve != null) {
            result
                ..add(r'approve')
                ..add(serializers.serialize(object.approve,
                    specifiedType: const FullType(bool)));
        }
        if (object.approverId != null) {
            result
                ..add(r'approverId')
                ..add(serializers.serialize(object.approverId,
                    specifiedType: const FullType(String)));
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
    ApproveDocumentRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = ApproveDocumentRequestBuilder();

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
                case r'approverId':
                    result.approverId = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
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

