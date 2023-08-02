package com.example.datingApp.controllers;

import com.example.datingApp.models.User;
import com.example.datingApp.response.ProfileResponse;
import com.example.datingApp.services.CrudService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/{id}/chats")
@AllArgsConstructor
public class ChatController {

    private final CrudService<User> userService;

    @GetMapping
    @ApiOperation(value = "", response = ProfileResponse.class)
    public ResponseEntity<List<User>> getAllChats(@PathVariable("id") int id) {
        return new ResponseEntity<>(userService.findById(id).getMutualLikes(), HttpStatus.OK);
    }

}
