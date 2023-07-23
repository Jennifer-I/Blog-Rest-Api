package com.jennifer.dtos.admindto;
import com.jennifer.enums.Gender;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminResponse {
    private Long id;
    private String UserName;
    private String email;
    private Gender gender;
    private LocalDateTime createdAt;

}
