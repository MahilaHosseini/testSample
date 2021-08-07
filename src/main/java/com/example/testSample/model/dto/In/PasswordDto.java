package com.example.testSample.model.dto.In;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordDto {

    private String currentPassword;
    private String newPassword;
    private String confirmPassword;
}
