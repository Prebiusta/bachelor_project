//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'inspect_document_request.g.dart';

/// InspectDocumentRequest
///
/// Properties:
/// * [delegatorId] 
/// * [isValid] 
/// * [processId] 
abstract class InspectDocumentRequest implements Built<InspectDocumentRequest, InspectDocumentRequestBuilder> {
    @BuiltValueField(wireName: r'delegatorId')
    String? get delegatorId;

    @BuiltValueField(wireName: r'isValid')
    bool? get isValid;

    @BuiltValueField(wireName: r'processId')
    String? get processId;

    InspectDocumentRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(InspectDocumentRequestBuilder b) => b;

    factory InspectDocumentRequest([void updates(InspectDocumentRequestBuilder b)]) = _$InspectDocumentRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<InspectDocumentRequest> get serializer => _$InspectDocumentRequestSerializer();
}

class _$InspectDocumentRequestSerializer implements StructuredSerializer<InspectDocumentRequest> {
    @override
    final Iterable<Type> types = const [InspectDocumentRequest, _$InspectDocumentRequest];

    @override
    final String wireName = r'InspectDocumentRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, InspectDocumentRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.delegatorId != null) {
            result
                ..add(r'delegatorId')
                ..add(serializers.serialize(object.delegatorId,
                    specifiedType: const FullType(String)));
        }
        if (object.isValid != null) {
            result
                ..add(r'isValid')
                ..add(serializers.serialize(object.isValid,
                    specifiedType: const FullType(bool)));
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
    InspectDocumentRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = InspectDocumentRequestBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'delegatorId':
                    result.delegatorId = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'isValid':
                    result.isValid = serializers.deserialize(value,
                        specifiedType: const FullType(bool)) as bool;
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

