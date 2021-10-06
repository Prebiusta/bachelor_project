package dk.signfluent.certificateauthority.certificatemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CAConfigurationValues {
    private String certificatePath;
    private String keystorePassword;
    private String keystoreType;
}
