package org.telran.shop.de.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.telran.shop.de.converter.Converter;
import org.telran.shop.de.dto.UserCreateDto;
import org.telran.shop.de.dto.UserResponseDto;
import org.telran.shop.de.entity.User;
import org.telran.shop.de.exception.UserNotFoundException;
import org.telran.shop.de.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// http://localhost:8080

@RestController
@RequestMapping("/api/users") // http://localhost:8080/api/users
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Converter<User, UserCreateDto, UserResponseDto> createConverter;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public UserResponseDto create(@RequestBody @Valid UserCreateDto userDto) {
        User user = createConverter.toEntity(userDto);
        User userFromDatabase = userService.create(user);
        UserResponseDto dto = createConverter.toDto(userFromDatabase);
        return dto;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/search")
    public User getByName(@RequestParam(name = "name") String name) {
        return userService.getByName(name);
    }

    @PostMapping("/equals_passwords")
    public List<User> getWithEqualsPassword(@RequestBody String password) {
        return userService.getWithEqualsPasswords(password);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(UserNotFoundException.class)
//    public String handleUserNotFoundExceptions(Exception exception) {
//        return exception.getMessage();
//    }

    //when save to DB
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(ConstraintViolationException.class)
//    public Map<String, String> handleValidationException(ConstraintViolationException exception) {
//        Map<String, String> errorMap = new HashMap<>();
//        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
//        for (ConstraintViolation violation : constraintViolations) {
//            String message = violation.getMessage();
//            String param = violation.getPropertyPath().toString();
//            errorMap.put(param, message);
//        }
//        return errorMap;
//    }


}
