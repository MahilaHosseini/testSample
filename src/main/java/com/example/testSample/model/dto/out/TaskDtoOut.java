package com.example.testSample.model.dto.out;

import com.example.testSample.model.enums.Priority;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TaskDtoOut {
    private Long id;
    private Date createdDate;
    private String title;
    private Priority priority;
    private Boolean done;
    private String user;
    private TaskDetailDtoOut taskDetail;
}
