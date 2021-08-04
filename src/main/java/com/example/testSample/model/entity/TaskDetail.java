package com.example.testSample.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "TASK_DETAIL")
public class TaskDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;
    @Column(name = "CREATED_DATE", updatable = false)
    @CreatedDate
    private Date createdDate;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "DEADLINE")
    private Integer deadline;
    @OneToOne(mappedBy = "taskDetail")
    private Task task;


}
