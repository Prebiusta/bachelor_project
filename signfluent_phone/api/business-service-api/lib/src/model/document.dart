//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:business_service_api/src/model/user.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'document.g.dart';

/// Document
///
/// Properties:
/// * [description] 
/// * [status] 
/// * [uploadedAt] 
/// * [uploadedBy] 
abstract class Document implements Built<Document, DocumentBuilder> {
    @BuiltValueField(wireName: r'description')
    String? get description;

    @BuiltValueField(wireName: r'status')
    String? get status;

    @BuiltValueField(wireName: r'uploadedAt')
    DateTime? get uploadedAt;

    @BuiltValueField(wireName: r'uploadedBy')
    User? get uploadedBy;

    Document._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(DocumentBuilder b) => b;

    factory Document([void updates(DocumentBuilder b)]) = _$Document;

    @BuiltValueSerializer(custom: true)
    static Serializer<Document> get serializer => _$DocumentSerializer();
}

class _$DocumentSerializer implements StructuredSerializer<Document> {
    @override
    final Iterable<Type> types = const [Document, _$Document];

    @override
    final String wireName = r'Document';

    @override
    Iterable<Object?> serialize(Serializers serializers, Document object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.description != null) {
            result
                ..add(r'description')
                ..add(serializers.serialize(object.description,
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
    Document deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = DocumentBuilder();

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

