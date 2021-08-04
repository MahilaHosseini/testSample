package com.example.testSample.dto.out;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class UserDtoOut {

    private Long id;
    private Date createdDate;
    private String userName;
    private String password;
    private ProfileDtoOut profile;

}
