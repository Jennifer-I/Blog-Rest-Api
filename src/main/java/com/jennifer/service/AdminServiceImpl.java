package com.jennifer.service;

import com.jennifer.dtos.admindto.AdminLoginRequest;
import com.jennifer.dtos.admindto.AdminRequest;
import com.jennifer.dtos.admindto.AdminResponse;
import com.jennifer.entities.Admin;
import com.jennifer.exceptions.UserAlreadyExistException;
import com.jennifer.exceptions.UserNotFoundException;
import com.jennifer.repository.AdminRepository;
import com.jennifer.utils.EntityMapper;
import com.jennifer.utils.ResponseManager;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;
    private final EntityMapper entityMapper;

    public AdminServiceImpl(AdminRepository adminRepository, EntityMapper entityMapper) {
        this.adminRepository = adminRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public ResponseManager createAdmin(AdminRequest adminRequest) {
        Optional<Admin> optionalUser = adminRepository.findByEmail(adminRequest.getEmail());
        if (optionalUser.isPresent()) throw new UserAlreadyExistException();
        Admin admin1 = entityMapper.dtoToAdminMapper(adminRequest);
        adminRepository.save(admin1);
        AdminResponse adminResponse = entityMapper.adminToDtoMapper(admin1);
        return ResponseManager.builder().message("request successful").status("00").data(adminResponse).build();
    }
    @Override
    public ResponseManager loginAdmin(AdminLoginRequest adminLoginRequest, HttpServletRequest request) {
        Optional<Admin> optionalAdmin = adminRepository.findByEmailAndPassword(adminLoginRequest.getEmail(), adminLoginRequest.getPassword());
        if (optionalAdmin.isEmpty()) {
            throw new UserNotFoundException();
        }
            AdminResponse adminResponse = entityMapper.adminToDtoMapper(optionalAdmin.get());
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("admin_id", adminResponse.getId());
            return ResponseManager.builder().message("login successful").status("01").data(adminResponse).build();
        }


    }
