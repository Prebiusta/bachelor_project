package dk.signfluent.service.ca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CAConfigurationValues {
    private String certificatePath;
    private String keyStorePassword;
    private String keystoreType;
}
