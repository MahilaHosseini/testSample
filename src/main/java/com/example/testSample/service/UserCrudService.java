package com.example.testSample.service;

import com.example.testSample.model.entity.User;
import com.example.testSample.model.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserCrudService {
    @Autowired
    private UserDao userDao;


    public void addUser(User newUser) {
        if (Objects.nonNull(newUser))
            userDao.save(newUser);
        else
            System.out.println("no user found");
    }

    public void deleteUser(String userName) {
        User user = userDao.findByUserName(userName);
        if (!user.getDeleted()) {
            user.setDeleted(true);
            user.getProfile().setDeleted(true);
            userDao.save(user);
        }
        else
            System.out.println("user not exist");
    }

    //    changePassword or username or edit profile fields
    public void updateUser(User user) {
        if (Objects.nonNull(user)) {
            Optional<User> userToUpdate = userDao.findById(user.getId());
            if (Objects.nonNull(userToUpdate) && !userToUpdate.get().getDeleted())
                userDao.save(user);
            else
                System.out.println("user not exist");
        }
    }
}

