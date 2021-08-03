package com.example.testSample.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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
