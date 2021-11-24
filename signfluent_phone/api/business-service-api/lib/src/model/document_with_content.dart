//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:business_service_api/src/model/user0.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'document_with_content.g.dart';

/// DocumentWithContent
///
/// Properties:
/// * [content] 
/// * [description] 
/// * [status] 
/// * [uploadedAt] 
/// * [uploadedBy] 
abstract class DocumentWithContent implements Built<DocumentWithContent, DocumentWithContentBuilder> {
    @BuiltValueField(wireName: r'content')
    String? get content;

    @BuiltValueField(wireName: r'description')
    String? get description;

    @BuiltValueField(wireName: r'status')
    String? get status;

    @BuiltValueField(wireName: r'uploadedAt')
    DateTime? get uploadedAt;

    @BuiltValueField(wireName: r'uploadedBy')
    User0? get uploadedBy;

    DocumentWithContent._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(DocumentWithContentBuilder b) => b;

    factory DocumentWithContent([void updates(DocumentWithContentBuilder b)]) = _$DocumentWithContent;

    @BuiltValueSerializer(custom: true)
    static Serializer<DocumentWithContent> get serializer => _$DocumentWithContentSerializer();
}

class _$DocumentWithContentSerializer implements StructuredSerializer<DocumentWithContent> {
    @override
    final Iterable<Type> types = const [DocumentWithContent, _$DocumentWithContent];

    @override
    final String wireName = r'DocumentWithContent';

    @override
    Iterable<Object?> serialize(Serializers serializers, DocumentWithContent object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.content != null) {
            result
                ..add(r'content')
                ..add(serializers.serialize(object.content,
                    specifiedType: const FullType(String)));
        }
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
                    specifiedType: const FullType(User0)));
        }
        return result;
    }

    @override
    DocumentWithContent deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = DocumentWithContentBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'content':
                    result.content = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
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
                        specifiedType: const FullType(User0)) as User0);
                    break;
            }
        }
        return result.build();
    }
}

