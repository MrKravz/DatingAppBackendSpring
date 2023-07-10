package com.example.datingApp.controllers;

import com.example.datingApp.dtos.UserDto;
import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.exceptions.errorResponses.UserErrorResponse;
import com.example.datingApp.models.User;
import com.example.datingApp.services.DtoService;
import com.example.datingApp.services.UserModelProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@Api(value = "User controller")
public class UserController {

    private final DtoService<UserDto, User> userService;
    private final UserModelProviderService userModelProviderService;

    @GetMapping("/new")
    @ApiOperation(value = "Get empty user to create a new user", response = UserDto.class)
    public ResponseEntity<UserDto> newUser(){
        return new ResponseEntity<>(userModelProviderService.configureUserModel(), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create a new user", response = HttpStatus.class)
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserDto userDto){
        userService.saveDto(userDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PatchMapping("/user/{id}")
    @ApiOperation(value = "Edit user information", response = HttpStatus.class)
    public ResponseEntity<HttpStatus> editUserInfo(@RequestBody UserDto userDto, @PathVariable("id") int id){
        userService.updateDto(userDto, id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "Get user by his id", response = UserDto.class)
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
