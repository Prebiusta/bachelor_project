//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'base_response.g.dart';

/// BaseResponse
///
/// Properties:
/// * [message] 
/// * [successful] 
abstract class BaseResponse implements Built<BaseResponse, BaseResponseBuilder> {
    @BuiltValueField(wireName: r'message')
    String? get message;

    @BuiltValueField(wireName: r'successful')
    bool? get successful;

    BaseResponse._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(BaseResponseBuilder b) => b;

    factory BaseResponse([void updates(BaseResponseBuilder b)]) = _$BaseResponse;

    @BuiltValueSerializer(custom: true)
    static Serializer<BaseResponse> get serializer => _$BaseResponseSerializer();
}

class _$BaseResponseSerializer implements StructuredSerializer<BaseResponse> {
    @override
    final Iterable<Type> types = const [BaseResponse, _$BaseResponse];

    @override
    final String wireName = r'BaseResponse';

    @override
    Iterable<Object?> serialize(Serializers serializers, BaseResponse object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.message != null) {
            result
                ..add(r'message')
                ..add(serializers.serialize(object.message,
                    specifiedType: const FullType(String)));
        }
        if (object.successful != null) {
            result
                ..add(r'successful')
                ..add(serializers.serialize(object.successful,
                    specifiedType: const FullType(bool)));
        }
        return result;
    }

    @override
    BaseResponse deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = BaseResponseBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'message':
                    result.message = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'successful':
                    result.successful = serializers.deserialize(value,
                        specifiedType: const FullType(bool)) as bool;
                    break;
            }
        }
        return result.build();
    }
}

