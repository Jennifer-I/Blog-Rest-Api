package com.jennifer.service;

import com.jennifer.dtos.userdto.UserLoginRequest;
import com.jennifer.dtos.userdto.UserRequest;
import com.jennifer.dtos.userdto.UserResponse;
import com.jennifer.entities.User;
import com.jennifer.exceptions.UserAlreadyExistException;
import com.jennifer.exceptions.UserNotFoundException;
import com.jennifer.repository.UserRepository;
import com.jennifer.utils.EntityMapper;
import com.jennifer.utils.ResponseManager;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final EntityMapper entityMapper;

    public UserServiceImpl(UserRepository userRepository, EntityMapper entityMapper) {
        this.userRepository = userRepository;
        this.entityMapper = entityMapper;
    }
    @Override
    public ResponseManager createUser(UserRequest userRequest){
    Optional<User> optionalUser = userRepository.findByEmail(userRequest.getEmail());
    if(optionalUser.isPresent())throw new UserAlreadyExistException();
    User user = entityMapper.dtoToUserMapper(userRequest);
    userRepository.save(user);
    UserResponse userResponse = entityMapper.userToDtoMapper(user);
    return ResponseManager.builder().message("request successful").status("00").data(userResponse).build();

    }
    @Override
    public ResponseManager loginUser(UserLoginRequest userLoginRequest, HttpServletRequest request){
        Optional<User> optionalUser = userRepository.findByEmailAndPassword(userLoginRequest.getEmail(), userLoginRequest.getPassword());
        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException();
        }
            UserResponse userResponse = entityMapper.userToDtoMapper(optionalUser.get());
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user_id",userResponse);
            return ResponseManager.builder().message("login successful").status("01").data(userResponse).build();
        }






    }









