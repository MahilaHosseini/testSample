package com.example.testSample.model.entity;

import com.example.testSample.enums.Priority;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TASK")
public class Task extends BaseEntity {

    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "PRIORITY")
    private Priority priority;
    @Column(name = "IS_DONE")
    private Boolean done;
    @ManyToOne
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TASK_DETAIL_ID", referencedColumnName = "ID", nullable = false)
    private TaskDetail taskDetail;


}
