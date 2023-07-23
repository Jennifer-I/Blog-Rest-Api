package com.jennifer.dtos.admindto;


import com.jennifer.enums.Gender;
import lombok.Data;



@Data
public class AdminRequest {
    private String userName;
    private String password;

    private String email;

    private Gender gender;
}
