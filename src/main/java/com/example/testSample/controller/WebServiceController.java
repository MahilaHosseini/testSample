package com.example.testSample.controller;

import com.example.testSample.model.entity.Profile;
import com.example.testSample.model.entity.User;
import com.example.testSample.service.UserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class WebServiceController {
    @Autowired
    UserCrudService userCrudService;

//    Profile profile = new Profile("Mahila", "Hosseini", "0020575823", false);
//    User user = new User("Mahi76", "12345", false, profile);

    @RequestMapping(value = "/ws/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        if (Objects.nonNull(user))
            userCrudService.addUser(user);
    }

    @RequestMapping(value = "/ws/deleteUser", method = RequestMethod.GET)
    public void deleteUser(@RequestParam String userName) {
        if (Objects.nonNull(userName))
            userCrudService.deleteUser(userName);
    }

    @RequestMapping(value = "/ws/updateUser", method = RequestMethod.POST)
    public void updateUser(@RequestBody User user) {
        if (Objects.nonNull(user))
            userCrudService.updateUser(user);
    }

}
