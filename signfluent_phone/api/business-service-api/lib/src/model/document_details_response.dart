//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:business_service_api/src/model/user_action_response.dart';
import 'package:business_service_api/src/model/approval_order_response.dart';
import 'package:built_collection/built_collection.dart';
import 'package:business_service_api/src/model/signature0.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'document_details_response.g.dart';

/// DocumentDetailsResponse
///
/// Properties:
/// * [approvalOrder] 
/// * [content] 
/// * [delegatedBy] 
/// * [description] 
/// * [documentId] 
/// * [hash] 
/// * [rejectedBy] 
/// * [signatures] 
/// * [status] 
/// * [uploadedBy] 
abstract class DocumentDetailsResponse implements Built<DocumentDetailsResponse, DocumentDetailsResponseBuilder> {
    @BuiltValueField(wireName: r'approvalOrder')
    BuiltList<ApprovalOrderResponse>? get approvalOrder;

    @BuiltValueField(wireName: r'content')
    String? get content;

    @BuiltValueField(wireName: r'delegatedBy')
    UserActionResponse? get delegatedBy;

    @BuiltValueField(wireName: r'description')
    String? get description;

    @BuiltValueField(wireName: r'documentId')
    String? get documentId;

    @BuiltValueField(wireName: r'hash')
    String? get hash;

    @BuiltValueField(wireName: r'rejectedBy')
    UserActionResponse? get rejectedBy;

    @BuiltValueField(wireName: r'signatures')
    BuiltList<Signature0>? get signatures;

    @BuiltValueField(wireName: r'status')
    String? get status;

    @BuiltValueField(wireName: r'uploadedBy')
    UserActionResponse? get uploadedBy;

    DocumentDetailsResponse._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(DocumentDetailsResponseBuilder b) => b;

    factory DocumentDetailsResponse([void updates(DocumentDetailsResponseBuilder b)]) = _$DocumentDetailsResponse;

    @BuiltValueSerializer(custom: true)
    static Serializer<DocumentDetailsResponse> get serializer => _$DocumentDetailsResponseSerializer();
}

class _$DocumentDetailsResponseSerializer implements StructuredSerializer<DocumentDetailsResponse> {
    @override
    final Iterable<Type> types = const [DocumentDetailsResponse, _$DocumentDetailsResponse];

    @override
    final String wireName = r'DocumentDetailsResponse';

    @override
    Iterable<Object?> serialize(Serializers serializers, DocumentDetailsResponse object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.approvalOrder != null) {
            result
                ..add(r'approvalOrder')
                ..add(serializers.serialize(object.approvalOrder,
                    specifiedType: const FullType(BuiltList, [FullType(ApprovalOrderResponse)])));
        }
        if (object.content != null) {
            result
                ..add(r'content')
                ..add(serializers.serialize(object.content,
                    specifiedType: const FullType(String)));
        }
        if (object.delegatedBy != null) {
            result
                ..add(r'delegatedBy')
                ..add(serializers.serialize(object.delegatedBy,
                    specifiedType: const FullType(UserActionResponse)));
        }
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
        if (object.hash != null) {
            result
                ..add(r'hash')
                ..add(serializers.serialize(object.hash,
                    specifiedType: const FullType(String)));
        }
        if (object.rejectedBy != null) {
            result
                ..add(r'rejectedBy')
                ..add(serializers.serialize(object.rejectedBy,
                    specifiedType: const FullType(UserActionResponse)));
        }
        if (object.signatures != null) {
            result
                ..add(r'signatures')
                ..add(serializers.serialize(object.signatures,
                    specifiedType: const FullType(BuiltList, [FullType(Signature0)])));
        }
        if (object.status != null) {
            result
                ..add(r'status')
                ..add(serializers.serialize(object.status,
                    specifiedType: const FullType(String)));
        }
        if (object.uploadedBy != null) {
            result
                ..add(r'uploadedBy')
                ..add(serializers.serialize(object.uploadedBy,
                    specifiedType: const FullType(UserActionResponse)));
        }
        return result;
    }

    @override
    DocumentDetailsResponse deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = DocumentDetailsResponseBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'approvalOrder':
                    result.approvalOrder.replace(serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(ApprovalOrderResponse)])) as BuiltList<ApprovalOrderResponse>);
                    break;
                case r'content':
                    result.content = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'delegatedBy':
                    result.delegatedBy.replace(serializers.deserialize(value,
                        specifiedType: const FullType(UserActionResponse)) as UserActionResponse);
                    break;
                case r'description':
                    result.description = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'documentId':
                    result.documentId = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'hash':
                    result.hash = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'rejectedBy':
                    result.rejectedBy.replace(serializers.deserialize(value,
                        specifiedType: const FullType(UserActionResponse)) as UserActionResponse);
                    break;
                case r'signatures':
                    result.signatures.replace(serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(Signature0)])) as BuiltList<Signature0>);
                    break;
                case r'status':
                    result.status = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'uploadedBy':
                    result.uploadedBy.replace(serializers.deserialize(value,
                        specifiedType: const FullType(UserActionResponse)) as UserActionResponse);
                    break;
            }
        }
        return result.build();
    }
}

