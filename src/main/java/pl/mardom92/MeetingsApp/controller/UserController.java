package pl.mardom92.MeetingsApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.mardom92.MeetingsApp.model.dto.UserDto;
import pl.mardom92.MeetingsApp.model.enums.UserRole;
import pl.mardom92.MeetingsApp.service.user.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public List<UserDto> getAllUsersByRole(@RequestParam(required = false) List<UserRole> role) {

        return userService.getAllUsersByRole(role);
    }

    @GetMapping("/{id}")
    public UserDto getSingleUser(@PathVariable long id) {
        return userService.getSingleUser(id);
    }

    @RequestMapping("/authenticated_info")
    public AuthenticatedPrincipal getAuthenticatedPrincipalInfo(@AuthenticationPrincipal AuthenticatedPrincipal principal) {
        return userService.getAuthenticatedPrincipalInfo(principal);
    }

    @PostMapping("")
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    @PutMapping("/{id}")
    public void editUser(@PathVariable long id, @RequestBody UserDto userDto) {
        userService.editUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
