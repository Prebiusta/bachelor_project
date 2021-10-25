package dk.signfluent.service.user.provider;

import dk.signfluent.integration.keycloak.util.SignfluentRole;
import dk.signfluent.service.user.model.AvailableRoleResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolesProvider {
    public List<AvailableRoleResponse> getAvailableRoles() {
        return Arrays.stream(SignfluentRole.values())
                .map(this::mapSignfluentRoleToResponse)
                .collect(Collectors.toList());
    }

    private AvailableRoleResponse mapSignfluentRoleToResponse(SignfluentRole signfluentRole) {
        AvailableRoleResponse response = new AvailableRoleResponse();
        response.setKey(signfluentRole.getKey());
        response.setName(signfluentRole.getName());
        return response;
    }
}
