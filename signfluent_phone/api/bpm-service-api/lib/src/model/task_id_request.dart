//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'task_id_request.g.dart';

/// TaskIdRequest
///
/// Properties:
/// * [taskId] 
abstract class TaskIdRequest implements Built<TaskIdRequest, TaskIdRequestBuilder> {
    @BuiltValueField(wireName: r'taskId')
    String? get taskId;

    TaskIdRequest._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(TaskIdRequestBuilder b) => b;

    factory TaskIdRequest([void updates(TaskIdRequestBuilder b)]) = _$TaskIdRequest;

    @BuiltValueSerializer(custom: true)
    static Serializer<TaskIdRequest> get serializer => _$TaskIdRequestSerializer();
}

class _$TaskIdRequestSerializer implements StructuredSerializer<TaskIdRequest> {
    @override
    final Iterable<Type> types = const [TaskIdRequest, _$TaskIdRequest];

    @override
    final String wireName = r'TaskIdRequest';

    @override
    Iterable<Object?> serialize(Serializers serializers, TaskIdRequest object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.taskId != null) {
            result
                ..add(r'taskId')
                ..add(serializers.serialize(object.taskId,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    TaskIdRequest deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = TaskIdRequestBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'taskId':
                    result.taskId = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

