package com.example.datingApp.controllers;

import com.example.datingApp.dtos.ProfileDto;
import com.example.datingApp.exceptions.ProfileNotFoundException;
import com.example.datingApp.exceptions.errorResponses.ProfileErrorResponse;
import com.example.datingApp.mappers.ProfileMapper;
import com.example.datingApp.models.Profile;
import com.example.datingApp.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("*/profile")
@AllArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDto> getProfileById(@PathVariable("id") int id){
        return new ResponseEntity<>(profileMapper.toDto(profileService.findById(id)), HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ProfileErrorResponse> handleException(ProfileNotFoundException ex){
        return new ResponseEntity<>(
                new ProfileErrorResponse("Profile with this id does not exist", System.currentTimeMillis()),
                HttpStatus.NOT_FOUND);
    }
}
