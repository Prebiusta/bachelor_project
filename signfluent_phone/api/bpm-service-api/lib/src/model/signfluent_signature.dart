//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'signfluent_signature.g.dart';

/// SignfluentSignature
///
/// Properties:
/// * [signedContent] 
/// * [taskId] 
/// * [x509Pem] 
abstract class SignfluentSignature implements Built<SignfluentSignature, SignfluentSignatureBuilder> {
    @BuiltValueField(wireName: r'signedContent')
    String? get signedContent;

    @BuiltValueField(wireName: r'taskId')
    String? get taskId;

    @BuiltValueField(wireName: r'x509Pem')
    String? get x509Pem;

    SignfluentSignature._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(SignfluentSignatureBuilder b) => b;

    factory SignfluentSignature([void updates(SignfluentSignatureBuilder b)]) = _$SignfluentSignature;

    @BuiltValueSerializer(custom: true)
    static Serializer<SignfluentSignature> get serializer => _$SignfluentSignatureSerializer();
}

class _$SignfluentSignatureSerializer implements StructuredSerializer<SignfluentSignature> {
    @override
    final Iterable<Type> types = const [SignfluentSignature, _$SignfluentSignature];

    @override
    final String wireName = r'SignfluentSignature';

    @override
    Iterable<Object?> serialize(Serializers serializers, SignfluentSignature object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.signedContent != null) {
            result
                ..add(r'signedContent')
                ..add(serializers.serialize(object.signedContent,
                    specifiedType: const FullType(String)));
        }
        if (object.taskId != null) {
            result
                ..add(r'taskId')
                ..add(serializers.serialize(object.taskId,
                    specifiedType: const FullType(String)));
        }
        if (object.x509Pem != null) {
            result
                ..add(r'x509Pem')
                ..add(serializers.serialize(object.x509Pem,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    SignfluentSignature deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SignfluentSignatureBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'signedContent':
                    result.signedContent = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'taskId':
                    result.taskId = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'x509Pem':
                    result.x509Pem = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

