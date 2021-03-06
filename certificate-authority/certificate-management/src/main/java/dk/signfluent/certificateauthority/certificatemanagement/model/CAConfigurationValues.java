package dk.signfluent.certificateauthority.certificatemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CAConfigurationValues {
    private String keystorePassword;
    private String keystoreType;
    private String certificatePem;
}
