package dk.signfluent.businessservice.controller.api;

import dk.signfluent.businessservice.service.UserService;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.model.User;
import dk.signfluent.user.service.model.UserCreateRequest;
import dk.signfluent.user.service.model.UserCreateResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

import java.util.List;

import static dk.signfluent.businessservice.utility.AuthorizationTypes.ADMINISTRATOR;
import static dk.signfluent.businessservice.utility.AuthorizationTypes.AUTHENTICATED;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    @ApiOperation(value = "Creates a new user", nickname = "createUser")
    @PreAuthorize(ADMINISTRATOR)
    public UserCreateResponse createUser(@RequestBody UserCreateRequest userCreateRequest) throws ApiException {
        return userService.createUser(userCreateRequest);
    }

    @PostMapping("/getAllUsers")
    @ApiOperation(value = "Returns all available users", nickname = "getAllUsers")
    @PreAuthorize(ADMINISTRATOR)
    public List<User> getAllUsers() throws ApiException {
        return userService.getAllUsers();
    }

    @PostMapping("/getUserDetails/{userId}")
    @ApiOperation(value = "Return details of specified user", nickname = "getUserDetails")
    @PreAuthorize(ADMINISTRATOR)
    public User getUserDetails(@PathVariable String userId) throws ApiException {
        return userService.getUserDetails(userId);
    }

    @PostMapping("/getCurrentUserDetails")
    @ApiOperation(value = "Returns details of authenticated user", nickname = "getCurrentUserDetails")
    @PreAuthorize(AUTHENTICATED)
    public User getCurrentUserDetails() throws ApiException {
        return userService.getCurrentUserDetails();
    }
}
