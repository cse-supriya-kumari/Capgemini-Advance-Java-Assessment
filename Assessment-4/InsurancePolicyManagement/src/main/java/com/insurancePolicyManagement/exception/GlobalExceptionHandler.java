package com.insurancePolicyManagement.exception;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PolicyNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePolicyNotFound(
            PolicyNotFoundException ex,
            HttpServletRequest request){

        ErrorResponse error = new ErrorResponse();

        error.setTimestamp(LocalDateTime.now());
        error.setStatus(404);
        error.setError(ex.getMessage());
        error.setPath(request.getRequestURI());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}