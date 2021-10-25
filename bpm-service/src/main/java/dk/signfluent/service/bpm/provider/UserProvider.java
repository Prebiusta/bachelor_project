package dk.signfluent.service.bpm.provider;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserProvider {
    public String getCurrentUserId() {
        return ((Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getName();
    }
}
