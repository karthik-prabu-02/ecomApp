package com.ecom.customer.handler;

import com.ecom.customer.exception.CustomerNotFoundException;
import com.ecom.customer.model.ErrorRespose;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException exp) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exp.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorRespose> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
        var errors = new HashMap<String ,String >();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError)error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName,errorMessage);
                });
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorRespose(errors));
    }
}
