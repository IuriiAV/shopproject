package org.telran.shop.de.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.telran.shop.de.exception.CardNotFoundException;
import org.telran.shop.de.exception.ProductNotFoundException;
import org.telran.shop.de.exception.UserNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class,
            ProductNotFoundException.class,
            CardNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundExceptions(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errorMap = new HashMap<>();
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        for (ObjectError error : allErrors) {
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            errorMap.put(field, defaultMessage);
        }
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

//    //@Valid for arguments + save to DB
//    //@ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handleArgumentValidationException(MethodArgumentNotValidException exception, WebRequest request) {
//        Map<String, String> errorMap = new HashMap<>();
//        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
//        for (ObjectError error : allErrors) {
//            String field = ((FieldError) error).getField();
//            String defaultMessage = error.getDefaultMessage();
//            errorMap.put(field,defaultMessage);
//        }
//        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
//    }
}