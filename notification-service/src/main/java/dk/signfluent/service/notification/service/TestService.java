package dk.signfluent.service.notification.service;

import dk.signfluent.service.notification.model.TestClass;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public TestClass getTestClass() {
        return new TestClass("Hello");
    }
}
