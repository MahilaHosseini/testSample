package com.example.testSample.model.dto.In;

import com.example.testSample.model.enums.Priority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDtoIn {


    private String title;
    private Priority priority;
    private Long userId;
    private TaskDetailDtoIn taskDetail;

}
