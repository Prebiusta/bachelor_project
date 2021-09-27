package dk.signfluent.service.user.service;

import dk.signfluent.service.user.model.TestClass;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public TestClass getTestClass() {
        return new TestClass("Hello");
    }
}
