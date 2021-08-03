package com.example.testSample.controller;

import com.example.testSample.model.entity.Task;
import com.example.testSample.service.TaskCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class TaskWebServiceController {
    final
    TaskCrudService taskCrudService;


    public TaskWebServiceController(TaskCrudService taskCrudService) {
        this.taskCrudService = taskCrudService;
    }

    @RequestMapping(value = "/ws/addTask", method = RequestMethod.POST)
    public void addTask(@RequestBody Task task) {
        if (Objects.nonNull(task)) {
            taskCrudService.addTask(task);
        }
    }

    @RequestMapping(value = "/ws/deleteTask", method = RequestMethod.GET)
    public void deleteTask(@RequestParam Long id) {
        if (Objects.nonNull(id)) {
            taskCrudService.deleteTask(id);
        }
    }

    @RequestMapping(value = "/ws/doTask", method = RequestMethod.GET)
    public void doTask(@RequestParam Long id) {
        if (Objects.nonNull(id)) {
            taskCrudService.updateTask(id);
        }
    }


}
