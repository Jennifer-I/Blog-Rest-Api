package com.jennifer.utils;

import com.jennifer.dtos.admindto.AdminRequest;
import com.jennifer.dtos.admindto.AdminResponse;
import com.jennifer.dtos.userdto.UserRequest;
import com.jennifer.dtos.userdto.UserResponse;
import com.jennifer.entities.Admin;
import com.jennifer.entities.User;
import org.springframework.stereotype.Service;

@Service
public class EntityMapper {
    public User dtoToUserMapper(UserRequest userRequest) {
        User user  = new User();
        user.setEmail(userRequest.getEmail());
        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        return user;
    }

    public UserResponse userToDtoMapper(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setUserName(user.getUserName());
        userResponse.setCreatedAt(user.getCreatedAt());
        return userResponse;
    }

    public Admin dtoToAdminMapper(AdminRequest adminRequest) {
        Admin admin = new Admin();
        admin.setEmail(adminRequest.getEmail());
        admin.setUserName(adminRequest.getUserName());
        admin.setGender(adminRequest.getGender());
        admin.setPassword(adminRequest.getPassword());
        return admin;
    }

    public AdminResponse adminToDtoMapper(Admin admin) {
        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setId(admin.getId());
        adminResponse.setUserName(admin.getUserName());
        adminResponse.setEmail(admin.getEmail());
        adminResponse.setGender(admin.getGender());
        adminResponse.setCreatedAt(admin.getCreatedAt());
        return adminResponse;
    }
}



