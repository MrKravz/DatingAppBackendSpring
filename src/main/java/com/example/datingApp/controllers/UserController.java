package com.example.datingApp.controllers;

import com.example.datingApp.dtos.UserDto;
import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.exceptions.errorResponses.UserErrorResponse;
import com.example.datingApp.models.User;
import com.example.datingApp.services.DtoService;
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
