package com.example.testSample.dto;

import com.example.testSample.model.entity.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDtoIn{

    private String userName;
    private String password;
    private Profile profile;

}
