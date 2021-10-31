//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'register_device_request.g.dart';

/// RegisterDeviceRequest
///
/// Properties:
/// * [deviceHardwareId] 
/// * [userId] 
abstract class RegisterDeviceRequest implements Built<RegisterDeviceRequest, RegisterDeviceRequestBuilder> {
    @BuiltValueField(wireName: r'deviceHardwareId')
    String? get deviceHardwareId;

    @BuiltValueField(wireName: r'userId')
    String? get userId;

    RegisterDeviceRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(RegisterDeviceRequestBuilder b) => b;

    factory RegisterDeviceRequest([void updates(RegisterDeviceRequestBuilder b)]) = _$RegisterDeviceRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<RegisterDeviceRequest> get serializer => _$RegisterDeviceRequestSerializer();
}

class _$RegisterDeviceRequestSerializer implements StructuredSerializer<RegisterDeviceRequest> {
    @override
    final Iterable<Type> types = const [RegisterDeviceRequest, _$RegisterDeviceRequest];

    @override
    final String wireName = r'RegisterDeviceRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, RegisterDeviceRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.deviceHardwareId != null) {
            result
                ..add(r'deviceHardwareId')
                ..add(serializers.serialize(object.deviceHardwareId,
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
    RegisterDeviceRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = RegisterDeviceRequestBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'deviceHardwareId':
                    result.deviceHardwareId = serializers.deserialize(value,
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

