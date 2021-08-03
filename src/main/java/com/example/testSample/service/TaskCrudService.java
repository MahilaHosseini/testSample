package com.example.testSample.service;

import com.example.testSample.model.entity.Task;
import com.example.testSample.model.repository.TaskDao;

import java.util.Objects;
import java.util.Optional;

public class TaskCrudService {
    private TaskDao taskDao;

    public void addTask(Task newTask) {
        if (Objects.nonNull(newTask))
            taskDao.save(newTask);
        else
            System.out.println("task null");
    }

    public void deleteTask(Long id) {
        Optional<Task> task = taskDao.findById(id);
        task.ifPresent(value -> taskDao.delete(value));
    }

    //only means it's done
    public void updateTask(Long id) {
        Optional<Task> task = taskDao.findById(id);
        task.ifPresent((value) -> {
            value.setDone(true);
            taskDao.save(value);
        });
    }


}
