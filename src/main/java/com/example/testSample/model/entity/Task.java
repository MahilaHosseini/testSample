package com.example.testSample.model.entity;

import com.example.testSample.model.enums.Priority;
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
@Table(name = "TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;
    @Column(name = "CREATED_DATE", updatable = false)
    @CreatedDate
    private Date createdDate;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "PRIORITY")
    private Priority priority;
    @Column(name = "IS_DONE")
    private Boolean done;
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID", insertable = false, updatable = false, referencedColumnName = "ID", nullable = false)
    private User user;
    @Column(name = "USER_ID", nullable = false)
    private Long userId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TASK_DETAIL_ID", referencedColumnName = "ID", nullable = false)
    private TaskDetail taskDetail;


}
