package dk.signfluent.service.bpm.utility;

public interface AuthorizationTypes {
    String ADMINISTRATOR = "hasAuthority('administrator')";
    String APPROVER = "hasAuthority('approver')";
    String DELEGATOR = "hasAuthority('delegator')";

    String DELEGATOR_OR_APPROVER = "hasAnyAuthority('delegator', 'approver')";
}
