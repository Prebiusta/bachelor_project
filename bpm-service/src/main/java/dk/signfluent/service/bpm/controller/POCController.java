package dk.signfluent.service.bpm.controller;

import dk.signfluent.service.bpm.model.Document;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static dk.signfluent.service.bpm.utility.ProcessVariables.DOCUMENT_ID;
import static dk.signfluent.service.bpm.utility.Processes.SIGNING_PROCESS;

@RestController
@RequestMapping("/api/poc")
public class POCController {
    private final RuntimeService runtimeService;
    private final TaskService taskService;

    public POCController(RuntimeService runtimeService, TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    @GetMapping("/uploadDocument")
    public String uploadDocument(@RequestBody Document document) {
        String documentId = "Some id after sending document to doc service";
        Map<String, Object> variables = new HashMap<>();
        variables.put(DOCUMENT_ID, documentId);
        runtimeService.startProcessInstanceByKey(SIGNING_PROCESS, documentId, variables);
        return "Process Instance created and started";
    }

    @GetMapping("/start")
    public String startProcess() {
        runtimeService.startProcessInstanceByKey("process");
        return "Process Instance created and started";
    }

    @PostMapping("/upload/{taskID}/{docID}")
    public void uploadDocumentId(@PathVariable String taskID, @PathVariable String docID) {
        //May use this later
       //String processInstanceId = taskService.createTaskQuery().list().stream().filter(task -> task.getId().equalsIgnoreCase(taskID)).findFirst().get().getProcessInstanceId();
        Map<String, Object> variables = new HashMap<>();
        variables.put("DOCUMENTID", docID);
        taskService.complete(taskID, variables);
    }

    @PostMapping("/retrieve/{taskID}")
    public Object fetchDocument(@PathVariable String taskID) {
        Map<String, Object> variables = taskService.getVariables(taskID);
        return variables.get("DOCUMENT");
    }
}
