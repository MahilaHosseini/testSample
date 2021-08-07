package com.example.testSample.controller;

import com.example.testSample.model.dto.In.UserDtoIn;
import com.example.testSample.model.dto.In.PasswordDto;
import com.example.testSample.model.dto.out.UserDtoOut;
import com.example.testSample.repository.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody UserDtoIn user) {
        userService.addUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam String userName) throws Exception {
        userService.deleteUser(userName);
    }

    @PutMapping
    public void updateUser(@RequestBody UserDtoIn user, @RequestParam Long id) throws Exception {
        userService.updateUser(id, user);
    }

    @PutMapping(value = "/changePassword")
    public void changePassword(@RequestBody PasswordDto passwordDto, @RequestParam String username) throws Exception {
        userService.changePassword(passwordDto, username);
    }

    @GetMapping(value = "/login")
    public void login(@RequestParam String password, @RequestParam String userName) throws Exception {
        userService.userLogin(password, userName);
    }

    @GetMapping(value = "/find")
    public UserDtoOut findUser(@RequestParam String userName) throws Exception {
        return userService.findUser(userName);
    }

}
