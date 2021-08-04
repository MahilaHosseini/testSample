package com.example.testSample.controller;

import com.example.testSample.dto.In.TaskDtoIn;
import com.example.testSample.dto.out.TaskDtoOut;
import com.example.testSample.service.TaskCrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class TaskWebServiceController {
    final
    TaskCrudService taskCrudService;


    public TaskWebServiceController(TaskCrudService taskCrudService) {
        this.taskCrudService = taskCrudService;
    }

    @RequestMapping(value = "/ws/addTask", method = RequestMethod.POST)
    public void addTask(@RequestBody TaskDtoIn task) {
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

    @RequestMapping(value = "/ws/getAllTasks", method = RequestMethod.GET)
    public @ResponseBody
    List<TaskDtoOut> getAllTasks(@RequestParam String username) {
        if (Objects.nonNull(username)) {
            return taskCrudService.getAllTasks(username);
        }
        return null;
    }


}
