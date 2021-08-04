package com.example.testSample.service;

import com.example.testSample.dto.TaskDtoIn;
import com.example.testSample.dto.TaskDtoOut;
import com.example.testSample.model.entity.Task;
import com.example.testSample.model.entity.User;
import com.example.testSample.model.repository.TaskDao;
import com.example.testSample.model.repository.UserDao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskCrudService {
    private final TaskDao taskDao;
    final
    UserDao userDao;
    ModelMapper modelMapper = new ModelMapper();

    public TaskCrudService(TaskDao taskDao, UserDao userDao) {
        this.taskDao = taskDao;
        this.userDao = userDao;
    }

    public void addTask(TaskDtoIn newTask) {
        if (Objects.nonNull(newTask)) {
            User user = userDao.findByUserName(newTask.getUser());
            Task task = modelMapper.map(newTask, Task.class);
            task.setDone(false);
            user.addTask(task);
            taskDao.save(task);
            userDao.save(user);
        } else
            System.out.println("task null");
    }

    //really deletes it
    public void deleteTask(Long id) {
        Optional<Task> task = taskDao.findById(id);
        task.ifPresent(taskDao::delete);
    }

    //only means it's done
    public void updateTask(Long id) {
        Optional<Task> task = taskDao.findById(id);
        task.ifPresent((value) -> {
            value.setDone(true);
            taskDao.save(value);
        });
    }


    public List<TaskDtoOut> getAllTasks(String username) {
        List<Task> tasks = taskDao.findAllByUser(username);
        return tasks.stream().map(user -> modelMapper.map(user, TaskDtoOut.class)).collect(Collectors.toList());
    }
}
