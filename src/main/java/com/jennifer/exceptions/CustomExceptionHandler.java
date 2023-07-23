package com.jennifer.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
   @ExceptionHandler(UserAlreadyExistException.class)
   public ResponseEntity<?> responseException(UserAlreadyExistException userAlreadyExistException){

       return ResponseEntity.badRequest().body(userAlreadyExistException.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity <?> responseException(UserNotFoundException userNotFoundException){
        return ResponseEntity.badRequest().body(userNotFoundException.getMessage());
    }
    @ExceptionHandler(NonexistentEntityException.class)
        public ResponseEntity<?> responseException(NonexistentEntityException nonexistentEntityException){
       return ResponseEntity.badRequest().body(nonexistentEntityException.getMessage());
    }
}
