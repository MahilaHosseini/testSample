package com.example.testSample.dto.In;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDtoIn {

    private String userName;
    private String password;
    private ProfileDtoIn profile;

}
