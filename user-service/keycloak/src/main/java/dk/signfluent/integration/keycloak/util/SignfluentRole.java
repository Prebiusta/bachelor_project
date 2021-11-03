package dk.signfluent.integration.keycloak.util;

import lombok.Getter;

@Getter
public enum SignfluentRole {
    APPROVER("approver", "Approver"),
    DELEGATOR("delegator", "Delegator"),
    ADMINISTRATOR("administrator", "Administrator"),
    ;

    private final String key, name;

    SignfluentRole(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public static SignfluentRole resolveRoleForKey(String key) {
        SignfluentRole[] roles = SignfluentRole.values();
        for (SignfluentRole role : roles) {
            if (role.getKey().equalsIgnoreCase(key))
                return role;
        }
        return null;
    }
}
