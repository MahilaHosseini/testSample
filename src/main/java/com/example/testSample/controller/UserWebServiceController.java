package com.example.testSample.controller;

import com.example.testSample.dto.In.UserDtoIn;
import com.example.testSample.dto.out.UserDtoOut;
import com.example.testSample.service.UserCrudService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class UserWebServiceController {
    final
    UserCrudService userCrudService;

    public UserWebServiceController(UserCrudService userCrudService) {
        this.userCrudService = userCrudService;
    }


    @RequestMapping(value = "/ws/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody UserDtoIn user) {
        if (Objects.nonNull(user)) {
            userCrudService.addUser(user);
        }

    }

    @RequestMapping(value = "/ws/deleteUser", method = RequestMethod.GET)
    public void deleteUser(@RequestParam String userName) {
        if (Objects.nonNull(userName)) {
            userCrudService.deleteUser(userName);
        }
    }

    @RequestMapping(value = "/ws/updateUser", method = RequestMethod.POST)
    public void updateUser(@RequestBody UserDtoIn user, @RequestParam Long id) {
        if (Objects.nonNull(user)) {
            userCrudService.updateUser(id, user);
        }
    }

    @RequestMapping(value = "/ws/logIn", method = RequestMethod.GET)
    public void logIn(@RequestParam String password, @RequestParam String userName) {
        if (Objects.nonNull(password) && Objects.nonNull(userName)) {
            userCrudService.userLogIn(password, userName);
        }
    }

    @RequestMapping(value = "/ws/findUser", method = RequestMethod.GET)
    public @ResponseBody
    UserDtoOut findUser(@RequestParam String userName) {
        return userCrudService.findUser(userName);
    }

}
