package com.example.testSample.model.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "USER")
@Where(clause = "IS_DELETED=false")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;
    @Column(name = "CREATED_DATE", updatable = false)
    @CreatedDate
    private Date createdDate;
    @Column(name = "USER_NAME", nullable = false)
    private String userName;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "ID")
    private Profile profile;
    @OneToMany
    private List<Task> tasks;
}
