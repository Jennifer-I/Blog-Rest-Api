package com.jennifer.dtos.userdto;

import com.jennifer.enums.Gender;
import lombok.Data;

@Data
public class UserRequest {
    private String userName;
    private String password;

    private String email;

    private Gender gender;
}
