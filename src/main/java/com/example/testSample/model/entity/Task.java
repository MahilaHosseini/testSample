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

}
