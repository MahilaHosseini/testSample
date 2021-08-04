package com.example.testSample.dto.out;

import com.example.testSample.enums.Priority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDtoOut extends BaseDtoOut {
    private String title;
    private Priority priority;
    private Boolean done;
    private String user;
    private TaskDetailDtoOut taskDetail;
}
