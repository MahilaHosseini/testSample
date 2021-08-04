package com.example.testSample.dto;

import com.example.testSample.enums.Priority;
import com.example.testSample.model.entity.TaskDetail;
import com.example.testSample.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class TaskDtoIn {


    private String title;
    private Priority priority;
    private String user;
    private TaskDetail taskDetail;

}
