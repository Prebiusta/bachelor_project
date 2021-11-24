//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:business_service_api/src/model/user.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'document_response.g.dart';

/// DocumentResponse
///
/// Properties:
/// * [description] 
/// * [documentId] 
/// * [status] 
/// * [uploadedAt] 
/// * [uploadedBy] 
abstract class DocumentResponse implements Built<DocumentResponse, DocumentResponseBuilder> {
    @BuiltValueField(wireName: r'description')
    String? get description;

    @BuiltValueField(wireName: r'documentId')
    String? get documentId;

    @BuiltValueField(wireName: r'status')
    String? get status;

    @BuiltValueField(wireName: r'uploadedAt')
    DateTime? get uploadedAt;

    @BuiltValueField(wireName: r'uploadedBy')
    User? get uploadedBy;

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
        if (object.description != null) {
            result
                ..add(r'description')
                ..add(serializers.serialize(object.description,
                    specifiedType: const FullType(String)));
        }
        if (object.documentId != null) {
            result
                ..add(r'documentId')
                ..add(serializers.serialize(object.documentId,
                    specifiedType: const FullType(String)));
        }
        if (object.status != null) {
            result
                ..add(r'status')
                ..add(serializers.serialize(object.status,
                    specifiedType: const FullType(String)));
        }
        if (object.uploadedAt != null) {
            result
                ..add(r'uploadedAt')
                ..add(serializers.serialize(object.uploadedAt,
                    specifiedType: const FullType(DateTime)));
        }
        if (object.uploadedBy != null) {
            result
                ..add(r'uploadedBy')
                ..add(serializers.serialize(object.uploadedBy,
                    specifiedType: const FullType(User)));
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
                case r'description':
                    result.description = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'documentId':
                    result.documentId = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'status':
                    result.status = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'uploadedAt':
                    result.uploadedAt = serializers.deserialize(value,
                        specifiedType: const FullType(DateTime)) as DateTime;
                    break;
                case r'uploadedBy':
                    result.uploadedBy.replace(serializers.deserialize(value,
                        specifiedType: const FullType(User)) as User);
                    break;
            }
        }
        return result.build();
    }
}

