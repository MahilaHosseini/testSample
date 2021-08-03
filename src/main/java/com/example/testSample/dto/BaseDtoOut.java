package com.example.testSample.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BaseDtoOut {
    private Long id;
    private Date createdDate;

    public BaseDtoOut(Long id, Date createdDate) {
        this.id = id;
        this.createdDate = createdDate;
    }
}
