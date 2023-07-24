package com.jennifer.controller;

import com.jennifer.dtos.admindto.AdminLoginRequest;
import com.jennifer.dtos.admindto.AdminRequest;
import com.jennifer.dtos.admindto.PostRequest;
import com.jennifer.service.AdminService;
import com.jennifer.service.PostService;
import com.jennifer.utils.ResponseManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("Api/v1/admin")
public class AdminController {
    private final AdminService adminService;
    private final PostService postService;

    public AdminController(AdminService adminService, PostService postService) {
        this.adminService = adminService;
        this.postService = postService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<ResponseManager> adminSignUp(@RequestBody AdminRequest adminRequest){
        ResponseManager responseManager = adminService.createAdmin(adminRequest);
        return new ResponseEntity<>(responseManager,HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<ResponseManager> adminLogin(@RequestBody AdminLoginRequest adminLoginRequest, HttpServletRequest request){
        ResponseManager responseManager = adminService.loginAdmin(adminLoginRequest,request);
        return new ResponseEntity<>(responseManager,HttpStatus.OK);
    }
    @PostMapping("/createPost")
    public ResponseEntity<ResponseManager> createPost(@RequestBody PostRequest postRequest, HttpServletRequest request){
        ResponseManager responseManager = postService.createPost(postRequest,request);
        return new ResponseEntity<>(responseManager,HttpStatus.OK);
    }
   @PatchMapping("/{postId}")
    public ResponseEntity<ResponseManager> updatePost( @PathVariable Long postId,@RequestBody PostRequest postRequest,HttpServletRequest request){
        ResponseManager responseManager = postService.updatePost(postRequest,postId,request);
        return  new ResponseEntity<>(responseManager,HttpStatus.OK);
    }

}
