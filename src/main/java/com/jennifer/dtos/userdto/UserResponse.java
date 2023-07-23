package com.jennifer.dtos.userdto;
import com.jennifer.enums.Gender;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private Long id;
    private String UserName;
    private String email;
    private Gender gender;
    private String role;
    private LocalDateTime createdAt;
}
