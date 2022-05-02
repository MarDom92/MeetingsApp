package pl.mardom92.MeetingsApp.controller;

import lombok.RequiredArgsConstructor;
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

    @PostMapping("")
    public UserDto addEUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @PutMapping("/{id}")
    public UserDto editUser(@PathVariable long id, @RequestBody UserDto userDto) {
        return userService.editUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
