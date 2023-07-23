package com.jennifer.service;

import com.jennifer.dtos.admindto.AdminLoginRequest;
import com.jennifer.dtos.admindto.AdminRequest;
import com.jennifer.utils.ResponseManager;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {
    ResponseManager createAdmin(AdminRequest adminRequest);

    ResponseManager loginAdmin(AdminLoginRequest adminLoginRequest, HttpServletRequest request);
}
