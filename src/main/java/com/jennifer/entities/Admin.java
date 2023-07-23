package com.jennifer.entities;

import com.jennifer.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name ="admin_table")
public class Admin extends BaseEntity{

    private String userName;
    private String password;
    @Column(name = "email", length = 50, unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Post> post;
    }



