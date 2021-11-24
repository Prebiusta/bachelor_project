//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:business_service_api/src/model/document_response.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'document_with_process_response.g.dart';

/// DocumentWithProcessResponse
///
/// Properties:
/// * [document] 
/// * [processId] 
abstract class DocumentWithProcessResponse implements Built<DocumentWithProcessResponse, DocumentWithProcessResponseBuilder> {
    @BuiltValueField(wireName: r'document')
    DocumentResponse? get document;

    @BuiltValueField(wireName: r'processId')
    String? get processId;

    DocumentWithProcessResponse._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(DocumentWithProcessResponseBuilder b) => b;

    factory DocumentWithProcessResponse([void updates(DocumentWithProcessResponseBuilder b)]) = _$DocumentWithProcessResponse;

    @BuiltValueSerializer(custom: true)
    static Serializer<DocumentWithProcessResponse> get serializer => _$DocumentWithProcessResponseSerializer();
}

class _$DocumentWithProcessResponseSerializer implements StructuredSerializer<DocumentWithProcessResponse> {
    @override
    final Iterable<Type> types = const [DocumentWithProcessResponse, _$DocumentWithProcessResponse];

    @override
    final String wireName = r'DocumentWithProcessResponse';

    @override
    Iterable<Object?> serialize(Serializers serializers, DocumentWithProcessResponse object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.document != null) {
            result
                ..add(r'document')
                ..add(serializers.serialize(object.document,
                    specifiedType: const FullType(DocumentResponse)));
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
    DocumentWithProcessResponse deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = DocumentWithProcessResponseBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'document':
                    result.document.replace(serializers.deserialize(value,
                        specifiedType: const FullType(DocumentResponse)) as DocumentResponse);
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

