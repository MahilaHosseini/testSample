package com.example.testSample.service;

import com.example.testSample.dto.UserDtoIn;
import com.example.testSample.dto.UserDtoOut;
import com.example.testSample.model.entity.User;
import com.example.testSample.model.repository.UserDao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserCrudService {
    private final UserDao userDao;
    ModelMapper modelMapper = new ModelMapper();

    public UserCrudService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(UserDtoIn newUser) {
        if (Objects.nonNull(newUser)) {
            User user = modelMapper.map(newUser, User.class);
            user.setIsDeleted(false);
            user.getProfile().setIsDeleted(false);
            userDao.save(user);
        }

//        else {
//            System.out.println("duplicate");
//        }
    }

    public void deleteUser(String userName) {
        if (Objects.nonNull(userName)) {
            User user = userDao.findByUserName(userName);
            if (Objects.nonNull(user)) {
                user.setIsDeleted(true);
                user.getProfile().setIsDeleted(true);
                userDao.save(user);
            } else {
                System.out.println("user not exist");
            }
        }
    }

    //    changePassword or username or edit profile fields
    public void updateUser(Long id, UserDtoIn user) {
        if (Objects.nonNull(user) && Objects.nonNull(id)) {
            Optional<User> userToUpdate = userDao.findById(id);
            if (userToUpdate.isPresent()) {
                userToUpdate.ifPresent((value) -> {
                    value.setPassword(user.getPassword());
                    value.setUserName(user.getUserName());
                    value.getProfile().setFirstName(user.getProfile().getFirstName());
                    value.getProfile().setLastName(user.getProfile().getLastName());
                    value.getProfile().setNationalCode(user.getProfile().getNationalCode());
                });
                userDao.save(userToUpdate.get());
            } else {
                System.out.println("user not exist");
            }
        }
    }

    public void userLogIn(String password, String userName) {
        if (Objects.nonNull(password) && Objects.nonNull(userName)) {
            User user = userDao.findByUserName(userName);
            if (user.getPassword().equals(password)) {
                System.out.println("logged in");
            } else {
                System.out.println(" wrong username or password");
            }
        }
    }

    public UserDtoOut findUser(String userName) {
        if (Objects.nonNull(userName)) {
            User user = userDao.findByUserName(userName);

            if (Objects.nonNull(user)) {
                return modelMapper.map(user, UserDtoOut.class);
            } else {
                System.out.println("user not exist");
            }

        }
        return null;
    }
}

