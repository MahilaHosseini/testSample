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
@Table(name = "PROFILE")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;
    @Column(name = "CREATED_DATE", updatable = false)
    @CreatedDate
    private Date createdDate;
    @Column(name = "FIRST_NAME", length = 30)
    private String firstName;
    @Column(name = "LAST_NAME", length = 50)
    private String lastName;
    @Column(name = "NATIONAL_CODE", unique = true, length = 10, nullable = false)
    private String nationalCode;
    @OneToOne(mappedBy = "profile")
    private User user;
}
