package dk.signfluent.service.bpm.provider;

import dk.signfluent.service.bpm.utility.ProcessFormKey;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProcessDetailsProvider {
    private final TaskService taskService;
    private final RuntimeService runtimeService;

    public ProcessDetailsProvider(TaskService taskService, RuntimeService runtimeService) {
        this.taskService = taskService;
        this.runtimeService = runtimeService;
    }

    public ProcessInstance getProcessInstanceById(String processInstanceId) {
        return runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
    }

    public List<ProcessInstance> getProcessInstancesWithFormKey(ProcessFormKey processFormKey) {
        Set<String> processInstanceIds = taskService.createTaskQuery().initializeFormKeys()
                .list()
                .stream()
                .filter(task -> task.getFormKey().equalsIgnoreCase(processFormKey.getFormKey()))
                .map(Task::getProcessInstanceId)
                .collect(Collectors.toSet());
        if (processInstanceIds.isEmpty())
            return Collections.emptyList();
        return runtimeService.createProcessInstanceQuery().processInstanceIds(processInstanceIds).list();
    }

    public List<ProcessInstance> getProcessInstancesWithFormKeyAndAssignee(ProcessFormKey processFormKey, String assignee) {
        Set<String> processInstanceIds = taskService.createTaskQuery().initializeFormKeys()
                .list()
                .stream()
                .filter(task -> task.getFormKey().equalsIgnoreCase(processFormKey.getFormKey()))
                .filter(task -> task.getAssignee().equalsIgnoreCase(assignee))
                .map(Task::getProcessInstanceId)
                .collect(Collectors.toSet());
        if (processInstanceIds.isEmpty())
            return Collections.emptyList();
        return runtimeService.createProcessInstanceQuery().processInstanceIds(processInstanceIds).list();
    }

    public Task getFirstTaskForProcessInstanceAndFormKey(String processInstanceId, ProcessFormKey processFormKey) {
        return getTaskStreamForProcessId(processInstanceId)
                .filter(task -> task.getFormKey().equals(processFormKey.getFormKey()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Given task not found for specified process instance"));
    }

    public Task getFirstTaskForProcessInstanceFormKeyAndAssignee(String processInstanceId, ProcessFormKey processFormKey, String assignee) {
        return getTaskStreamForProcessId(processInstanceId)
                .filter(task -> task.getFormKey().equals(processFormKey.getFormKey()))

                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Given task not found for specified process instance"));
    }

    private Stream<Task> getTaskStreamForProcessId(String processInstanceId) {
        return taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .initializeFormKeys()
                .list()
                .stream();
    }
}
