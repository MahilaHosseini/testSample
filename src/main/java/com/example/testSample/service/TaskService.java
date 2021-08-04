package com.example.testSample.service;

import com.example.testSample.dto.In.TaskDetailDtoIn;
import com.example.testSample.dto.In.TaskDtoIn;
import com.example.testSample.dto.In.TaskUpdateDto;
import com.example.testSample.dto.out.TaskDtoOut;
import com.example.testSample.model.entity.Task;
import com.example.testSample.model.entity.TaskDetail;
import com.example.testSample.model.repository.TaskDao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskDao taskDao;
    private final ModelMapper modelMapper = new ModelMapper();

    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
        modelMapper.typeMap(TaskDetailDtoIn.class, TaskDetail.class).addMappings(mapper -> {
            mapper.skip(TaskDetail::setTask);
        });
    }

    public void addTask(TaskDtoIn newTask) {
        if (Objects.nonNull(newTask)) {
            Task task = modelMapper.map(newTask, Task.class);
            task.setDone(false);
            taskDao.save(task);
        } else
            System.out.println("task null");
    }

    //really deletes it
    public void deleteTask(Long id) {
        taskDao.deleteById(id);
    }

    //only means it's done
    public void doTask(Long id) throws Exception {
        Optional<Task> task = taskDao.findById(id);
        if (task.isPresent()) {
            task.ifPresent((value) -> {
                value.setDone(true);
                taskDao.save(value);
            });
        } else throw new Exception();
    }

    public void updateTask(TaskUpdateDto taskUpdateDto, Long id) throws Exception {
        Optional<Task> task = taskDao.findById(id);
        if (task.isPresent()) {
            task.ifPresent((value) -> {
                value.setPriority(taskUpdateDto.getPriority());
                value.getTaskDetail().setDescription(taskUpdateDto.getTaskDetail().getDescription());
                value.getTaskDetail().setDeadline(taskUpdateDto.getTaskDetail().getDeadline());
                if (value.getDone()) {
                    value.setDone(false);
                }
                taskDao.save(value);
            });
        } else {
            throw new Exception();
        }
    }

    public List<TaskDtoOut> getAllTasks(Long userId) throws Exception {
        List<Task> tasks = taskDao.findAllByUserId(userId);
        if (Objects.isNull(tasks)) {
            throw new Exception();
        }
        return tasks.stream().map(task -> modelMapper.map(task, TaskDtoOut.class)).collect(Collectors.toList());
    }

    public void deleteAllUserTasks(Long userId){
        List<Task> tasks = taskDao.findAllByUserId(userId);
        if (Objects.nonNull(tasks)) {
            tasks.stream().forEach(task -> deleteTask(task.getId()));
        }
    }
}
