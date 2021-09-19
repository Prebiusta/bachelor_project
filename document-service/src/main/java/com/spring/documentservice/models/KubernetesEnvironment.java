package com.spring.documentservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KubernetesEnvironment {
    private String documentServiceURL;
    private String documentServicePort;
}
