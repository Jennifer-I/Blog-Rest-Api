package com.jennifer.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserAlreadyExistException extends  RuntimeException{
    private String message;
    private String status;
    @JsonIgnore
    private HttpStatus httpStatus;
    private Object data;

}
