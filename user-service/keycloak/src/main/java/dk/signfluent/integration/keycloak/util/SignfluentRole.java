package dk.signfluent.integration.keycloak.util;

import lombok.Getter;

@Getter
public enum SignfluentRole {
    APPROVER("approver", "Approver"),
    DELEGATOR("delegator", "Delegator"),
    ADMINISTRATOR("administrator", "Administrator"),
    USER("user", "User"),
    ;

    private final String key, name;

    SignfluentRole(String key, String name) {
        this.key = key;
        this.name = name;
    }
}
