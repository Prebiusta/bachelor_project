//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:business_service_api/src/model/device_entity.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'register_device_response.g.dart';

/// RegisterDeviceResponse
///
/// Properties:
/// * [deviceEntity] 
/// * [message] 
/// * [successful] 
abstract class RegisterDeviceResponse implements Built<RegisterDeviceResponse, RegisterDeviceResponseBuilder> {
    @BuiltValueField(wireName: r'deviceEntity')
    DeviceEntity? get deviceEntity;

    @BuiltValueField(wireName: r'message')
    String? get message;

    @BuiltValueField(wireName: r'successful')
    bool? get successful;

    RegisterDeviceResponse._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(RegisterDeviceResponseBuilder b) => b;

    factory RegisterDeviceResponse([void updates(RegisterDeviceResponseBuilder b)]) = _$RegisterDeviceResponse;

    @BuiltValueSerializer(custom: true)
    static Serializer<RegisterDeviceResponse> get serializer => _$RegisterDeviceResponseSerializer();
}

class _$RegisterDeviceResponseSerializer implements StructuredSerializer<RegisterDeviceResponse> {
    @override
    final Iterable<Type> types = const [RegisterDeviceResponse, _$RegisterDeviceResponse];

    @override
    final String wireName = r'RegisterDeviceResponse';

    @override
    Iterable<Object?> serialize(Serializers serializers, RegisterDeviceResponse object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.deviceEntity != null) {
            result
                ..add(r'deviceEntity')
                ..add(serializers.serialize(object.deviceEntity,
                    specifiedType: const FullType(DeviceEntity)));
        }
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
    RegisterDeviceResponse deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = RegisterDeviceResponseBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'deviceEntity':
                    result.deviceEntity.replace(serializers.deserialize(value,
                        specifiedType: const FullType(DeviceEntity)) as DeviceEntity);
                    break;
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

