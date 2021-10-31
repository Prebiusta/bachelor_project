//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:bpm_service_api/src/model/document.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'document_response.g.dart';

/// DocumentResponse
///
/// Properties:
/// * [document] 
/// * [taskId] 
abstract class DocumentResponse implements Built<DocumentResponse, DocumentResponseBuilder> {
    @BuiltValueField(wireName: r'document')
    Document? get document;

    @BuiltValueField(wireName: r'taskId')
    String? get taskId;

    DocumentResponse._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(DocumentResponseBuilder b) => b;

    factory DocumentResponse([void updates(DocumentResponseBuilder b)]) = _$DocumentResponse;

    @BuiltValueSerializer(custom: true)
    static Serializer<DocumentResponse> get serializer => _$DocumentResponseSerializer();
}

class _$DocumentResponseSerializer implements StructuredSerializer<DocumentResponse> {
    @override
    final Iterable<Type> types = const [DocumentResponse, _$DocumentResponse];

    @override
    final String wireName = r'DocumentResponse';

    @override
    Iterable<Object?> serialize(Serializers serializers, DocumentResponse object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.document != null) {
            result
                ..add(r'document')
                ..add(serializers.serialize(object.document,
                    specifiedType: const FullType(Document)));
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
    DocumentResponse deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = DocumentResponseBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'document':
                    result.document.replace(serializers.deserialize(value,
                        specifiedType: const FullType(Document)) as Document);
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

