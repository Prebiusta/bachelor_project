//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'issue_x509_certificate_request.g.dart';

/// IssueX509CertificateRequest
///
/// Properties:
/// * [publicKeyPem] 
/// * [userId] 
abstract class IssueX509CertificateRequest implements Built<IssueX509CertificateRequest, IssueX509CertificateRequestBuilder> {
    @BuiltValueField(wireName: r'publicKeyPem')
    String? get publicKeyPem;

    @BuiltValueField(wireName: r'userId')
    String? get userId;

    IssueX509CertificateRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(IssueX509CertificateRequestBuilder b) => b;

    factory IssueX509CertificateRequest([void updates(IssueX509CertificateRequestBuilder b)]) = _$IssueX509CertificateRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<IssueX509CertificateRequest> get serializer => _$IssueX509CertificateRequestSerializer();
}

class _$IssueX509CertificateRequestSerializer implements StructuredSerializer<IssueX509CertificateRequest> {
    @override
    final Iterable<Type> types = const [IssueX509CertificateRequest, _$IssueX509CertificateRequest];

    @override
    final String wireName = r'IssueX509CertificateRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, IssueX509CertificateRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.publicKeyPem != null) {
            result
                ..add(r'publicKeyPem')
                ..add(serializers.serialize(object.publicKeyPem,
                    specifiedType: const FullType(String)));
        }
        if (object.userId != null) {
            result
                ..add(r'userId')
                ..add(serializers.serialize(object.userId,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    IssueX509CertificateRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = IssueX509CertificateRequestBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'publicKeyPem':
                    result.publicKeyPem = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'userId':
                    result.userId = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

