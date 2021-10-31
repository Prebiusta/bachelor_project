//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'signfluent_signature_request.g.dart';

/// SignfluentSignatureRequest
///
/// Properties:
/// * [contentToBeSigned] 
/// * [taskId] 
abstract class SignfluentSignatureRequest implements Built<SignfluentSignatureRequest, SignfluentSignatureRequestBuilder> {
    @BuiltValueField(wireName: r'contentToBeSigned')
    String? get contentToBeSigned;

    @BuiltValueField(wireName: r'taskId')
    String? get taskId;

    SignfluentSignatureRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(SignfluentSignatureRequestBuilder b) => b;

    factory SignfluentSignatureRequest([void updates(SignfluentSignatureRequestBuilder b)]) = _$SignfluentSignatureRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<SignfluentSignatureRequest> get serializer => _$SignfluentSignatureRequestSerializer();
}

class _$SignfluentSignatureRequestSerializer implements StructuredSerializer<SignfluentSignatureRequest> {
    @override
    final Iterable<Type> types = const [SignfluentSignatureRequest, _$SignfluentSignatureRequest];

    @override
    final String wireName = r'SignfluentSignatureRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, SignfluentSignatureRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.contentToBeSigned != null) {
            result
                ..add(r'contentToBeSigned')
                ..add(serializers.serialize(object.contentToBeSigned,
                    specifiedType: const FullType(String)));
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
    SignfluentSignatureRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SignfluentSignatureRequestBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'contentToBeSigned':
                    result.contentToBeSigned = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
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

