//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'modify_daily_notification_time_request.g.dart';

/// ModifyDailyNotificationTimeRequest
///
/// Properties:
/// * [notificationTime] 
abstract class ModifyDailyNotificationTimeRequest implements Built<ModifyDailyNotificationTimeRequest, ModifyDailyNotificationTimeRequestBuilder> {
    @BuiltValueField(wireName: r'notificationTime')
    int? get notificationTime;

    ModifyDailyNotificationTimeRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(ModifyDailyNotificationTimeRequestBuilder b) => b;

    factory ModifyDailyNotificationTimeRequest([void updates(ModifyDailyNotificationTimeRequestBuilder b)]) = _$ModifyDailyNotificationTimeRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<ModifyDailyNotificationTimeRequest> get serializer => _$ModifyDailyNotificationTimeRequestSerializer();
}

class _$ModifyDailyNotificationTimeRequestSerializer implements StructuredSerializer<ModifyDailyNotificationTimeRequest> {
    @override
    final Iterable<Type> types = const [ModifyDailyNotificationTimeRequest, _$ModifyDailyNotificationTimeRequest];

    @override
    final String wireName = r'ModifyDailyNotificationTimeRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, ModifyDailyNotificationTimeRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.notificationTime != null) {
            result
                ..add(r'notificationTime')
                ..add(serializers.serialize(object.notificationTime,
                    specifiedType: const FullType(int)));
        }
        return result;
    }

    @override
    ModifyDailyNotificationTimeRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = ModifyDailyNotificationTimeRequestBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'notificationTime':
                    result.notificationTime = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    break;
            }
        }
        return result.build();
    }
}

