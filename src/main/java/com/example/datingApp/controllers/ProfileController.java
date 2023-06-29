package com.example.datingApp.controllers;

import com.example.datingApp.dtos.ProfileDto;
import com.example.datingApp.exceptions.ProfileNotFoundException;
import com.example.datingApp.exceptions.errorResponses.ProfileErrorResponse;
import com.example.datingApp.models.Profile;
import com.example.datingApp.services.DtoService;
import com.example.datingApp.services.ProfileModelService;
import com.example.datingApp.util.ProfileModel;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/{id}/profile")
@AllArgsConstructor
public class ProfileController {

    private final DtoService<ProfileDto, Profile> profileService;
    private final ProfileModelService profileModelService;

    @GetMapping("/new")
    public ResponseEntity<ProfileModel> newProfile(@PathVariable("id") int id){
        return new ResponseEntity<>(profileModelService.configureModel(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createProfile(@RequestBody ProfileDto profileDto){
        profileService.saveDto(profileDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PatchMapping("/{profile_id}")
    public ResponseEntity<HttpStatus> editProfileInfo(@RequestBody ProfileDto profileDto, @PathVariable("profile_id") int profile_id){
        profileService.updateDto(profileDto, profile_id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{profile_id}")
    public ResponseEntity<ProfileDto> getProfileById(@PathVariable("profile_id") int profile_id, @PathVariable("id") int id){
        return new ResponseEntity<>(profileService.findDtoById(profile_id), HttpStatus.OK);
    }

    @ExceptionHandler(ProfileNotFoundException.class)
    private ResponseEntity<ProfileErrorResponse> handleException(ProfileNotFoundException ex){
        return new ResponseEntity<>(
                new ProfileErrorResponse("Profile with this id does not exist", System.currentTimeMillis()),
                HttpStatus.NOT_FOUND);
    }
}
