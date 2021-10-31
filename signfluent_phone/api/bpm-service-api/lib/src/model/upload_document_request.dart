//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'upload_document_request.g.dart';

/// UploadDocumentRequest
///
/// Properties:
/// * [description] 
/// * [document] 
abstract class UploadDocumentRequest implements Built<UploadDocumentRequest, UploadDocumentRequestBuilder> {
    @BuiltValueField(wireName: r'description')
    String? get description;

    @BuiltValueField(wireName: r'document')
    String? get document;

    UploadDocumentRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(UploadDocumentRequestBuilder b) => b;

    factory UploadDocumentRequest([void updates(UploadDocumentRequestBuilder b)]) = _$UploadDocumentRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<UploadDocumentRequest> get serializer => _$UploadDocumentRequestSerializer();
}

class _$UploadDocumentRequestSerializer implements StructuredSerializer<UploadDocumentRequest> {
    @override
    final Iterable<Type> types = const [UploadDocumentRequest, _$UploadDocumentRequest];

    @override
    final String wireName = r'UploadDocumentRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, UploadDocumentRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.description != null) {
            result
                ..add(r'description')
                ..add(serializers.serialize(object.description,
                    specifiedType: const FullType(String)));
        }
        if (object.document != null) {
            result
                ..add(r'document')
                ..add(serializers.serialize(object.document,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    UploadDocumentRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = UploadDocumentRequestBuilder();

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
                case r'document':
                    result.document = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

