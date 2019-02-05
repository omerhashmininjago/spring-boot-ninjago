package com.lego.omer.error.controller;

import com.lego.omer.error.LegoCharacterNotFoundException;
import com.lego.omer.error.LegoTypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NinjagoExceptionController {

    @ExceptionHandler(value = LegoTypeNotFoundException.class)
    public ResponseEntity exception(LegoTypeNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = LegoCharacterNotFoundException.class)
    public ResponseEntity exception(LegoCharacterNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }


}
