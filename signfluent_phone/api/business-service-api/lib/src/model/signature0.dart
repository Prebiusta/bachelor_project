//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'signature0.g.dart';

/// Signature0
///
/// Properties:
/// * [certificate] 
/// * [id] 
/// * [signatureDate] 
/// * [signedHash] 
abstract class Signature0 implements Built<Signature0, Signature0Builder> {
    @BuiltValueField(wireName: r'certificate')
    String? get certificate;

    @BuiltValueField(wireName: r'id')
    String? get id;

    @BuiltValueField(wireName: r'signatureDate')
    DateTime? get signatureDate;

    @BuiltValueField(wireName: r'signedHash')
    String? get signedHash;

    Signature0._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(Signature0Builder b) => b;

    factory Signature0([void updates(Signature0Builder b)]) = _$Signature0;

    @BuiltValueSerializer(custom: true)
    static Serializer<Signature0> get serializer => _$Signature0Serializer();
}

class _$Signature0Serializer implements StructuredSerializer<Signature0> {
    @override
    final Iterable<Type> types = const [Signature0, _$Signature0];

    @override
    final String wireName = r'Signature0';

    @override
    Iterable<Object?> serialize(Serializers serializers, Signature0 object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.certificate != null) {
            result
                ..add(r'certificate')
                ..add(serializers.serialize(object.certificate,
                    specifiedType: const FullType(String)));
        }
        if (object.id != null) {
            result
                ..add(r'id')
                ..add(serializers.serialize(object.id,
                    specifiedType: const FullType(String)));
        }
        if (object.signatureDate != null) {
            result
                ..add(r'signatureDate')
                ..add(serializers.serialize(object.signatureDate,
                    specifiedType: const FullType(DateTime)));
        }
        if (object.signedHash != null) {
            result
                ..add(r'signedHash')
                ..add(serializers.serialize(object.signedHash,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    Signature0 deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = Signature0Builder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'certificate':
                    result.certificate = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'id':
                    result.id = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'signatureDate':
                    result.signatureDate = serializers.deserialize(value,
                        specifiedType: const FullType(DateTime)) as DateTime;
                    break;
                case r'signedHash':
                    result.signedHash = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

