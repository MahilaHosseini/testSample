package com.example.testSample.service;

import com.example.testSample.dto.In.ProfileDtoIn;
import com.example.testSample.dto.In.UserDtoIn;
import com.example.testSample.dto.out.UserDtoOut;
import com.example.testSample.model.entity.Profile;
import com.example.testSample.model.entity.User;
import com.example.testSample.model.repository.UserDao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;
    private final ModelMapper modelMapper = new ModelMapper();
    private final TaskService taskService;

    public UserService(UserDao userDao, TaskService taskService) {
        this.userDao = userDao;
        this.taskService = taskService;
        modelMapper.typeMap(ProfileDtoIn.class, Profile.class).addMappings(mapper -> {
            mapper.skip(Profile::setUser);
        });

    }

    public void addUser(UserDtoIn newUser) {
        if (Objects.nonNull(newUser)) {
            User user = modelMapper.map(newUser, User.class);
            user.setIsDeleted(false);
            userDao.save(user);
        }
//todo
    }

    public void deleteUser(String userName) throws Exception {
        if (Objects.nonNull(userName)) {
            User user = userDao.findByUserName(userName);
            if (Objects.nonNull(user)) {
                user.setIsDeleted(true);
                taskService.deleteAllUserTasks(user.getId());
                userDao.save(user);
            } else {
                throw new Exception();
            }
        }
    }

    //    change Password or username or edit profile fields
    public void updateUser(Long id, UserDtoIn user) throws Exception {
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
                throw new Exception();
            }
        }
    }

    public void userLogIn(String password, String userName) throws Exception {
        if (Objects.nonNull(password) && Objects.nonNull(userName)) {
            User user = userDao.findByUserName(userName);
            if (user.getPassword().equals(password)) {
                System.out.println("logged in");
            } else {
                throw new Exception();
            }
        }
    }

    public UserDtoOut findUser(String userName) throws Exception {
        if (Objects.nonNull(userName)) {
            User user = userDao.findByUserName(userName);
            if (Objects.nonNull(user)) {
                return modelMapper.map(user, UserDtoOut.class);
            } else {
                throw new Exception();
            }

        }
        return null;
    }
}

