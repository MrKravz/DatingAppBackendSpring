package com.example.datingApp.controllers;

import com.example.datingApp.dtos.ProfileDto;
import com.example.datingApp.exceptions.ProfilesNotFoundException;
import com.example.datingApp.exceptions.errorResponses.ProfilesErrorResponse;
import com.example.datingApp.mappers.ProfileMapper;
import com.example.datingApp.services.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/{id}/profiles")
@AllArgsConstructor
public class SwipeController {

    private final ProfileSwipeService profileSwipeService;
    private final ProfileMapper profileMapper;

    @GetMapping
    public ResponseEntity<List<ProfileDto>> getProfiles(@PathVariable("id") int id){
        return new ResponseEntity<>(profileMapper.toIterableDto(profileSwipeService.getSwipeList(id)), HttpStatus.OK);
    }

    @ExceptionHandler(ProfilesNotFoundException.class)
    private ResponseEntity<ProfilesErrorResponse> handleException(ProfilesNotFoundException ex){
        return new ResponseEntity<>(
                new ProfilesErrorResponse(ex.getMessage(), System.currentTimeMillis()),
                HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> likeProfile(@PathVariable("id") int id, @RequestBody ProfileDto profileDto){
        profileSwipeService.likeUser(id, profileDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
