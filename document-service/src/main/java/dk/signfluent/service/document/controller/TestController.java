package dk.signfluent.service.document.controller;

import dk.signfluent.service.document.model.TestClass;
import dk.signfluent.service.document.service.TestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * It's important to keep /dk.signfluent.service.document.api as base path for all controllers. All those controllers are handled
 * for CORS and Swagger code generation.
 *
 * @author David
 */
@RestController
@RequestMapping("/api/test-controller")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/get")
    @ApiOperation(value = "A Test Endpoint", nickname = "getTestClass")
    public TestClass getTestClass() {
        return testService.getTestClass();
    }
}
