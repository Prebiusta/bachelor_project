package dk.signfluent.service.document.service;

import dk.signfluent.service.document.model.TestClass;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public TestClass getTestClass() {
        return new TestClass("Hello");
    }
}
