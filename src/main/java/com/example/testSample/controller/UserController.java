package com.example.testSample.controller;

import com.example.testSample.dto.In.UserDtoIn;
import com.example.testSample.dto.out.UserDtoOut;
import com.example.testSample.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(@RequestBody UserDtoIn user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam String userName) throws Exception {
        userService.deleteUser(userName);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserDtoIn user, @RequestParam Long id) throws Exception {
        userService.updateUser(id, user);
    }

    @RequestMapping(value = "/logIn", method = RequestMethod.GET)
    public void logIn(@RequestParam String password, @RequestParam String userName) throws Exception {
        userService.userLogIn(password, userName);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public UserDtoOut findUser(@RequestParam String userName) throws Exception {
        return userService.findUser(userName);
    }

}
