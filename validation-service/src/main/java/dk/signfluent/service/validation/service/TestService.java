package dk.signfluent.service.validation.service;

import dk.signfluent.service.validation.model.TestClass;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public TestClass getTestClass() {
        return new TestClass("Hello");
    }
}
