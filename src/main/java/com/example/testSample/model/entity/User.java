package com.example.testSample.model.entity;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER")
public class User extends BaseEntity
{

    @Column (name = "USER_NAME",nullable = false)
    private String userName;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_ID" , referencedColumnName = "ID")
    private Profile profile;
}
