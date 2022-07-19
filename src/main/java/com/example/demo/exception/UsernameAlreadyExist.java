package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsernameAlreadyExist extends RuntimeException{
    public UsernameAlreadyExist(String message) {
        super(message);
    }
}
