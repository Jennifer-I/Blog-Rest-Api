package com.jennifer.service;

import com.jennifer.dtos.admindto.AdminResponse;
import com.jennifer.dtos.admindto.PostRequest;
import com.jennifer.entities.Admin;
import com.jennifer.entities.Post;
import com.jennifer.exceptions.NonexistentEntityException;
import com.jennifer.exceptions.UserNotFoundException;
import com.jennifer.repository.AdminRepository;
import com.jennifer.repository.PostRepository;
import com.jennifer.utils.ResponseManager;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final AdminRepository adminRepository;


    public PostServiceImpl(PostRepository postRepository,  AdminRepository adminRepository) {
        this.postRepository = postRepository;
        this.adminRepository = adminRepository;

    }
    @Override
    public ResponseManager createPost(PostRequest postRequest, HttpServletRequest request) {
        HttpSession session = request.getSession();
        AdminResponse adminResponse = (AdminResponse) session.getAttribute("admin_id");
//        Long AdminId = (Long) session.getAttribute("admin_id");
        Optional<Admin> optionalAdmin = adminRepository.findById(adminResponse.getId());
        if (optionalAdmin.isEmpty()) {
            throw new UserNotFoundException();
        }
            Post post = new Post();
            post.setTitle(postRequest.getTitle());
            post.setPostContent(postRequest.getPostContent());
            post.setCreatedAt(LocalDateTime.now());
            post.setAdmin(optionalAdmin.get());
            Post savedPost = postRepository.save(post);
           return ResponseManager.builder().message("post Created").status("01")
                  .data(savedPost).build();

        }
        @Override
        public ResponseManager updatePost(PostRequest postRequest, Long postId, HttpServletRequest request){
         HttpSession session = request.getSession();
        Long adminId = (Long) session.getAttribute("admin_id");
        Optional<Admin> optionalAdmin = adminRepository.findById(adminId);
        if (optionalAdmin.isEmpty()) {
            throw new UserNotFoundException();
        }
        Optional<Post> optionalPost = postRepository.findById(postId);
         if(optionalPost.isEmpty()){
             throw new NonexistentEntityException();
         }
         Post post = optionalPost.get();
         post.setTitle(postRequest.getTitle());
         post.setPostContent(postRequest.getPostContent());
         post.setUpdatedAt(LocalDateTime.now());
         post.setId(postId);
         postRepository.save(post);
         return   ResponseManager.builder().message("updated successfully").status("01").build();
        }

        }





