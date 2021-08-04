package com.example.testSample.controller;

import com.example.testSample.dto.In.TaskDtoIn;
import com.example.testSample.dto.In.TaskUpdateDto;
import com.example.testSample.dto.out.TaskDtoOut;
import com.example.testSample.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addTask(@RequestBody TaskDtoIn task) {
        taskService.addTask(task);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteTask(@RequestParam Long id) {
        taskService.deleteTask(id);
    }

    @RequestMapping(value = "/do", method = RequestMethod.PUT)
    public void doTask(@RequestParam Long id) throws Exception {
        taskService.doTask(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void editTask(@RequestParam Long id, @RequestBody TaskUpdateDto taskUpdateDto) throws Exception {
        taskService.updateTask(taskUpdateDto, id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<TaskDtoOut> getAllTasks(@RequestParam Long userId) throws Exception {
        return taskService.getAllTasks(userId);
    }

}
