package com.example.testSample.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserDtoOut extends BaseDtoOut {

    private String userName;
    private String password;
    private ProfileDtoOut profile;

}
