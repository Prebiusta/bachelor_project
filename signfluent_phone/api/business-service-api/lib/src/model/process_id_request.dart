//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'process_id_request.g.dart';

/// ProcessIdRequest
///
/// Properties:
/// * [processId] 
abstract class ProcessIdRequest implements Built<ProcessIdRequest, ProcessIdRequestBuilder> {
    @BuiltValueField(wireName: r'processId')
    String? get processId;

    ProcessIdRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(ProcessIdRequestBuilder b) => b;

    factory ProcessIdRequest([void updates(ProcessIdRequestBuilder b)]) = _$ProcessIdRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<ProcessIdRequest> get serializer => _$ProcessIdRequestSerializer();
}

class _$ProcessIdRequestSerializer implements StructuredSerializer<ProcessIdRequest> {
    @override
    final Iterable<Type> types = const [ProcessIdRequest, _$ProcessIdRequest];

    @override
    final String wireName = r'ProcessIdRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, ProcessIdRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.processId != null) {
            result
                ..add(r'processId')
                ..add(serializers.serialize(object.processId,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    ProcessIdRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = ProcessIdRequestBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'processId':
                    result.processId = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

