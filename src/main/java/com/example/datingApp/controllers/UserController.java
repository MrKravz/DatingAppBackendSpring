package com.example.datingApp.controllers;

import com.example.datingApp.dtos.UserDto;
import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.exceptions.errorResponses.UserErrorResponse;
import com.example.datingApp.models.User;
import com.example.datingApp.services.DtoService;
import com.example.datingApp.services.UserModelProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UserController {

    private final DtoService<UserDto, User> userService;
    private final UserModelProviderService userModelProviderService;

    @GetMapping("/new")
    public ResponseEntity<UserDto> newUser(){
        return new ResponseEntity<>(userModelProviderService.configureUserModel(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserDto userDto){
        userService.saveDto(userDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<HttpStatus> editUserInfo(@RequestBody UserDto userDto, @PathVariable("id") int id){
        userService.updateDto(userDto, id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") int id){
        return new ResponseEntity<>(userService.findDtoById(id), HttpStatus.OK);
    }

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<UserErrorResponse> handleException(UserNotFoundException ex){
        return new ResponseEntity<>(
                new UserErrorResponse(ex.getMessage(), System.currentTimeMillis()),
                HttpStatus.NOT_FOUND);
    }
}
