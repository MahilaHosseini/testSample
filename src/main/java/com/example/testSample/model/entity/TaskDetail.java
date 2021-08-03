package com.example.testSample.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TASK_DETAIL")
public class TaskDetail extends BaseEntity {
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "DEADLINE")
    private Integer deadline;
    @OneToOne(mappedBy = "taskDetail")
    private Task task;

    public TaskDetail(Long id, Date createdDate, String description, Integer deadline, Task task) {
        super(id, createdDate);
        this.description = description;
        this.deadline = deadline;
        this.task = task;
    }

    public TaskDetail() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
