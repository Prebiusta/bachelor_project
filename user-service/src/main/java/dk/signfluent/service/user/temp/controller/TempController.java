package dk.signfluent.service.user.temp.controller;

import dk.signfluent.service.user.temp.model.SignfluentSignature;
import dk.signfluent.service.user.temp.model.SignfluentSignatureRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temp")
public class TempController {
    @PostMapping("/get")
    public SignfluentSignatureRequest getSignatureRequestForUser(@RequestBody String userId) {
        return new SignfluentSignatureRequest("signMe", "123456");
    }

    @PostMapping("/submit")
    public String submitSignature(@RequestBody SignfluentSignature signfluentSignature) {
        return "Done";
    }
}
