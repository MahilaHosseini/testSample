package com.example.testSample.model.dto.In;

import com.example.testSample.model.enums.Priority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskUpdateDto {

    private Priority priority;
    private TaskDetailDtoIn taskDetail;
}
