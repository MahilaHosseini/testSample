package com.example.testSample.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TASK_DETAIL")
public class TaskDetail extends BaseEntity {
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "DEADLINE")
    private Integer deadline;
    @OneToOne(mappedBy = "taskDetail")
    private Task task;

}
