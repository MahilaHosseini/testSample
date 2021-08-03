package com.example.testSample.model.entity;

import com.example.testSample.enums.Priority;

import javax.persistence.*;

@Entity
@Table(name = "TASK")
public class Task extends BaseEntity {

    @Column(name = "TITLE",nullable = false)
    private String title;
    @Column(name = "PRIORITY")
    private Priority priority;
    @Column(name = "IS_DONE")
    private Boolean done;
    @ManyToOne
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TASK_DETAIL_ID" , referencedColumnName = "ID",nullable = false)
    private TaskDetail taskDetail;

    public Task(String title, Priority priority, Boolean done, User user, TaskDetail taskDetail) {
        this.title = title;
        this.priority = priority;
        this.done = done;
        this.user = user;
        this.taskDetail = taskDetail;
    }

    public Task() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskDetail getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(TaskDetail taskDetail) {
        this.taskDetail = taskDetail;
    }
}
