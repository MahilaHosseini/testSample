package com.example.testSample.dto;

import com.example.testSample.enums.Priority;
import com.example.testSample.model.entity.TaskDetail;
import com.example.testSample.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class TaskDtoOut extends BaseDtoOut{
    private String title;
    private Priority priority;
    private Boolean done;
    private String user;
    private TaskDetailDtoOut taskDetail;
}
