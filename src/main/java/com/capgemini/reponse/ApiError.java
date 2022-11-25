package com.capgemini.reponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Data
public class ApiError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String error;
    private String message;
    private HttpStatus status;


    public ApiError(HttpStatus status) {
        this();
        this.status = status;
    }


    public ApiError(HttpStatus status, String error) {
        this();
        this.status = status;
        this.error = error;
    }

    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status, String message, String error) {
        this();
        this.status = status;
        this.message = message;
        this.error = error;
    }


}
