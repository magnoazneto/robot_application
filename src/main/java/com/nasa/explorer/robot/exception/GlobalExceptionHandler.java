package com.nasa.explorer.robot.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class, RobotOutOfFieldException.class})
    public ResponseEntity<?> badRequestHandler(RuntimeException e) {
        // log message here
        return ResponseEntity.badRequest().body("400 Bad Request");
    }
}
