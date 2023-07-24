package com.jennifer.dtos.admindto;
import com.jennifer.enums.Gender;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {
    private Long id;
    private String UserName;
    private String email;
    private Gender gender;
    private LocalDateTime createdAt;

}
