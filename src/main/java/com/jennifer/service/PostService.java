package com.jennifer.service;

import com.jennifer.dtos.admindto.PostRequest;
import com.jennifer.utils.ResponseManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface PostService {
    ResponseManager createPost(PostRequest postRequest, HttpServletRequest request);

//    ResponseManager updatePost(PostRequest postRequest, Long postId);
}
