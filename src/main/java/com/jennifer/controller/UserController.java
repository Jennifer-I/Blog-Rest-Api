package com.jennifer.controller;

import com.jennifer.dtos.userdto.UserLoginRequest;
import com.jennifer.dtos.userdto.UserRequest;
import com.jennifer.service.UserService;
import com.jennifer.utils.ResponseManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("Api/vi/user")
public class UserController {
    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

   @PostMapping("/signUp")
    public ResponseEntity<ResponseManager> signUp(@RequestBody UserRequest userRequest) {
       ResponseManager responseManager = userService.createUser(userRequest);
       return new ResponseEntity<>(responseManager, HttpStatus.CREATED);
   }
   @PostMapping("/login")
    public ResponseEntity<ResponseManager> userLogin(@RequestBody UserLoginRequest userLoginRequest,HttpServletRequest request){
        ResponseManager responseManager = userService.loginUser(userLoginRequest,request);
        return new ResponseEntity<>(responseManager,HttpStatus.OK);
   }


    }
