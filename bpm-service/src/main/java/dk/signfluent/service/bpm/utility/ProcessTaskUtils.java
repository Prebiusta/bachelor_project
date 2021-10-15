package dk.signfluent.service.bpm.utility;

import org.camunda.bpm.engine.TaskService;
import org.springframework.stereotype.Component;

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
}
