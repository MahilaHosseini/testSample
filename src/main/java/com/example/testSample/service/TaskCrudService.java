package com.example.testSample.service;

import com.example.testSample.model.entity.Task;
import com.example.testSample.model.repository.TaskDao;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class TaskCrudService {
    private final TaskDao taskDao;

    public TaskCrudService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public void addTask(Task newTask) {
        if (Objects.nonNull(newTask)) {
            newTask.setDone(false);
            taskDao.save(newTask);
        } else
            System.out.println("task null");
    }

    //really deletes it
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
