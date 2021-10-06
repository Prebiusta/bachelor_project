package dk.signfluent.certificateauthority.certificatemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    private String userId;
    private byte[] publicKeyPem;
}
