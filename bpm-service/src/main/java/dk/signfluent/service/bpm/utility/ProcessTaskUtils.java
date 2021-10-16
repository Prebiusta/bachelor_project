package dk.signfluent.service.bpm.utility;

import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static dk.signfluent.service.bpm.utility.ProcessVariables.DOCUMENT_ID;

@Component
public class ProcessTaskUtils {
    private final TaskService taskService;

    public ProcessTaskUtils(TaskService taskService) {
        this.taskService = taskService;
    }

    public String getDocumentId(String taskId) {
        return (String) taskService.getVariables(taskId).get(DOCUMENT_ID);
    }

    public List<String> getDocumentIdsForFormKeyAndUser(ProcessFormKey processFormKey, String userId) {
        Stream<Task> taskStream = getTaskQueryStream()
                .filter(task -> task.getFormKey().equalsIgnoreCase(processFormKey.getFormKey()))
                .filter(task -> task.getAssignee().equalsIgnoreCase(userId));
        return convertTaskStreamToDocumentIds(taskStream);
    }

    public List<String> getDocumentIdsForFormKey(ProcessFormKey processFormKey) {
        Stream<Task> taskStream = getTaskQueryStream()
                .filter(task -> task.getFormKey().equalsIgnoreCase(processFormKey.getFormKey()));
        return convertTaskStreamToDocumentIds(taskStream);
    }

    private List<String> convertTaskStreamToDocumentIds(Stream<Task> taskStream) {
        return taskStream
                .map(Task::getId)
                .map(taskService::getVariables)
                .map(variables -> (String) variables.get(DOCUMENT_ID))
                .collect(Collectors.toList());
    }

    private Stream<Task> getTaskQueryStream() {
        return taskService.createTaskQuery().initializeFormKeys()
                .list()
                .stream();
    }
}
