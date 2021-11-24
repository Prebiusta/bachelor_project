package dk.signfluent.service.bpm.utility;

import lombok.Getter;

@Getter
public enum ProcessFormKey {
    INSPECT_DOCUMENT("inspectDocument"),
    ASSIGN_APPROVERS("assignApprovers"),
    APPROVE_DOCUMENT("approveDocument"),
    SIGN_DOCUMENT("signDocument"),
    VERIFY_SIGNATURE("verifysignature"),

    ;

    private final String formKey;

    ProcessFormKey(String formKey) {
        this.formKey = formKey;
    }
}
