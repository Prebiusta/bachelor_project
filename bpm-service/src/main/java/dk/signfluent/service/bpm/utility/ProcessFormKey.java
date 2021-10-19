package dk.signfluent.service.bpm.utility;

import lombok.Getter;

@Getter
public enum ProcessFormKey {
    ASSIGN_APPROVERS("assign_approvers"),
    SIGN("sign"),
    ;

    private final String formKey;

    ProcessFormKey(String formKey) {
        this.formKey = formKey;
    }
}
