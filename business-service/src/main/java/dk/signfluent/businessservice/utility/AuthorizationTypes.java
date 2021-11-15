package dk.signfluent.businessservice.utility;

public interface AuthorizationTypes {
    String ADMINISTRATOR = "hasAuthority('administrator')";
    String APPROVER = "hasAuthority('approver')";
    String DELEGATOR = "hasAuthority('delegator')";
    String AUTHENTICATED = "isAuthenticated";

    String DELEGATOR_OR_APPROVER = "hasAnyAuthority('delegator', 'approver')";
}
