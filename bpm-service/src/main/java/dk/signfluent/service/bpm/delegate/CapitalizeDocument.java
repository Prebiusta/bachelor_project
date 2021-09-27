package dk.signfluent.service.bpm.delegate;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static dk.signfluent.service.bpm.utility.ProcessVariables.CONTENT;


@Component
public class CapitalizeDocument implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        delegateExecution.getVariable(CONTENT);
    }
}
