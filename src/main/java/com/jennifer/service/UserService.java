package com.jennifer.service;

import com.jennifer.dtos.userdto.UserLoginRequest;
import com.jennifer.dtos.userdto.UserRequest;
import com.jennifer.utils.ResponseManager;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    ResponseManager createUser(UserRequest userRequest);

    ResponseManager loginUser(UserLoginRequest userLoginRequest, HttpServletRequest request);
}
