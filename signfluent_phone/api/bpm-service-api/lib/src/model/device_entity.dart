//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'device_entity.g.dart';

/// DeviceEntity
///
/// Properties:
/// * [deviceHardwareId] 
/// * [fcmtoken] 
/// * [id] 
/// * [userId] 
abstract class DeviceEntity implements Built<DeviceEntity, DeviceEntityBuilder> {
    @BuiltValueField(wireName: r'deviceHardwareId')
    String? get deviceHardwareId;

    @BuiltValueField(wireName: r'fcmtoken')
    String? get fcmtoken;

    @BuiltValueField(wireName: r'id')
    String? get id;

    @BuiltValueField(wireName: r'userId')
    String? get userId;

    DeviceEntity._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(DeviceEntityBuilder b) => b;

    factory DeviceEntity([void updates(DeviceEntityBuilder b)]) = _$DeviceEntity;

    @BuiltValueSerializer(custom: true)
    static Serializer<DeviceEntity> get serializer => _$DeviceEntitySerializer();
}

class _$DeviceEntitySerializer implements StructuredSerializer<DeviceEntity> {
    @override
    final Iterable<Type> types = const [DeviceEntity, _$DeviceEntity];

    @override
    final String wireName = r'DeviceEntity';

    @override
    Iterable<Object?> serialize(Serializers serializers, DeviceEntity object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.deviceHardwareId != null) {
            result
                ..add(r'deviceHardwareId')
                ..add(serializers.serialize(object.deviceHardwareId,
                    specifiedType: const FullType(String)));
        }
        if (object.fcmtoken != null) {
            result
                ..add(r'fcmtoken')
                ..add(serializers.serialize(object.fcmtoken,
                    specifiedType: const FullType(String)));
        }
        if (object.id != null) {
            result
                ..add(r'id')
                ..add(serializers.serialize(object.id,
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
    DeviceEntity deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = DeviceEntityBuilder();

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
                case r'fcmtoken':
                    result.fcmtoken = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'id':
                    result.id = serializers.deserialize(value,
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

