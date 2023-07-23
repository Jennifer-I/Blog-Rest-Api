package com.jennifer.utils;

import ch.qos.logback.core.status.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class ResponseManager {
    private String message;
    private String status;
    private Object data;
    @JsonIgnore
    private HttpStatus httpStatus;

    public ResponseManager(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ResponseManager(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public ResponseManager(Object data, HttpStatus httpStatus) {
        this.data = data;
        this.httpStatus = httpStatus;
    }

    public ResponseManager(String message, Object data, HttpStatus httpStatus) {
        this.message = message;
        this.data = data;
        this.httpStatus = httpStatus;
    }
}
