package com.spring.documentservice.controllers;

import com.spring.documentservice.models.KubernetesEnvironment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final KubernetesEnvironment kubernetesEnvironment;

    public TestController(KubernetesEnvironment kubernetesEnvironment) {
        this.kubernetesEnvironment = kubernetesEnvironment;
    }

    @GetMapping("/test")
    public String getK8sEnv() {
        return String.format("%s:%s", kubernetesEnvironment.getDocumentServiceURL(), kubernetesEnvironment.getDocumentServicePort());
    }
}
