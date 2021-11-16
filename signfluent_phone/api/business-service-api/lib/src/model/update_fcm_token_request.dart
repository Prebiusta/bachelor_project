//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'update_fcm_token_request.g.dart';

/// UpdateFCMTokenRequest
///
/// Properties:
/// * [deviceHardwareId] 
/// * [fcmToken] 
/// * [userId] 
abstract class UpdateFCMTokenRequest implements Built<UpdateFCMTokenRequest, UpdateFCMTokenRequestBuilder> {
    @BuiltValueField(wireName: r'deviceHardwareId')
    String? get deviceHardwareId;

    @BuiltValueField(wireName: r'fcmToken')
    String? get fcmToken;

    @BuiltValueField(wireName: r'userId')
    String? get userId;

    UpdateFCMTokenRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(UpdateFCMTokenRequestBuilder b) => b;

    factory UpdateFCMTokenRequest([void updates(UpdateFCMTokenRequestBuilder b)]) = _$UpdateFCMTokenRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<UpdateFCMTokenRequest> get serializer => _$UpdateFCMTokenRequestSerializer();
}

class _$UpdateFCMTokenRequestSerializer implements StructuredSerializer<UpdateFCMTokenRequest> {
    @override
    final Iterable<Type> types = const [UpdateFCMTokenRequest, _$UpdateFCMTokenRequest];

    @override
    final String wireName = r'UpdateFCMTokenRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, UpdateFCMTokenRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.deviceHardwareId != null) {
            result
                ..add(r'deviceHardwareId')
                ..add(serializers.serialize(object.deviceHardwareId,
                    specifiedType: const FullType(String)));
        }
        if (object.fcmToken != null) {
            result
                ..add(r'fcmToken')
                ..add(serializers.serialize(object.fcmToken,
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
    UpdateFCMTokenRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = UpdateFCMTokenRequestBuilder();

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
                case r'fcmToken':
                    result.fcmToken = serializers.deserialize(value,
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

