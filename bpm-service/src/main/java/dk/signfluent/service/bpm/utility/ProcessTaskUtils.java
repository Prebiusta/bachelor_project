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

    public String getDocumentId(String taskId){
        return (String) taskService.getVariables(taskId).get(DOCUMENT_ID);
    }

    public List<Task> getForUserAndFormKey(ProcessFormKey processFormKey, String userId) {
        return getTaskQueryStream()
                .filter(task -> task.getFormKey().equalsIgnoreCase(processFormKey.getFormKey()))
                .filter(task -> task.getAssignee().equalsIgnoreCase(userId))
                .collect(Collectors.toList());
    }

    public List<Task> getForUser(String userId) {
        return getTaskQueryStream()
                .filter(task -> task.getAssignee().equalsIgnoreCase(userId))
                .collect(Collectors.toList());
    }

    public List<Task> getForFormKey(ProcessFormKey processFormKey) {
        return getTaskQueryStream()
                .filter(task -> task.getFormKey().equalsIgnoreCase(processFormKey.getFormKey()))
                .collect(Collectors.toList());
    }

    private Stream<Task> getTaskQueryStream() {
        return taskService.createTaskQuery().initializeFormKeys()
                .list()
                .stream();
    }
}
