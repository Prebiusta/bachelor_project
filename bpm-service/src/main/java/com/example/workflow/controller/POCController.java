package com.example.workflow.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class POCController {
    private final RuntimeService runtimeService;
    private final TaskService taskService;

    public POCController(RuntimeService runtimeService, TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    @PostMapping("/start")
    public void startProcess() {
        runtimeService.startProcessInstanceByKey("process");
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
