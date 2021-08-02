package com.example.testSample.model.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PROFILE")
public class Profile extends BaseEntity {


    @Column(name = "FIRST_NAME", length = 30)
    private String firstName;
    @Column(name = "LAST_NAME", length = 50)
    private String lastName;
    @Column(name = "NATIONAL_CODE", unique = true, length = 10, nullable = false)
    private String nationalCode;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted;
    @OneToOne(mappedBy = "profile")
    private User user;

}
