package com.example.testSample.dto.In;

import com.example.testSample.enums.Priority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskUpdateDto {

    private Priority priority;
    private TaskDetailDtoIn taskDetail;
}
