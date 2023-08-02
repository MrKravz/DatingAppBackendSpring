package com.example.datingApp.controllers;

import com.example.datingApp.dtos.PreferenceDto;
import com.example.datingApp.dtos.ProfileDto;
import com.example.datingApp.exceptions.ProfilesNotFoundException;
import com.example.datingApp.exceptions.errorResponses.ProfilesErrorResponse;
import com.example.datingApp.mappers.ProfileMapper;
import com.example.datingApp.models.Preference;
import com.example.datingApp.services.*;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/{id}/profiles")
@AllArgsConstructor
@Api(value = "Swipe controller")
public class SwipeController {

    private final ProfileSwipeService profileSwipeService;
    private final ProfileMapper profileMapper;
    private final DtoService<PreferenceDto, Preference> preferenceService;

    @GetMapping
    @ApiOperation(value = "Get profiles that match with user preference", response = List.class)
    public ResponseEntity<List<ProfileDto>> getProfiles(@PathVariable("id") int id){
        return new ResponseEntity<>(profileMapper.toListDto(profileSwipeService.getSwipeList(id)), HttpStatus.OK);
    }

    @ExceptionHandler(ProfilesNotFoundException.class)
    private ResponseEntity<ProfilesErrorResponse> handleException(ProfilesNotFoundException ex){
        return new ResponseEntity<>(
                new ProfilesErrorResponse(ex.getMessage(), System.currentTimeMillis()),
                HttpStatus.NOT_FOUND);
    }

    @PostMapping("/like/{profile_id}")
    @ApiOperation(value = "Like profile, returns true if like is mutual", response = Boolean.class)
    public ResponseEntity<Boolean> likeProfile(@PathVariable("id") int id, @PathVariable("profile_id") int profile_id){
        return new ResponseEntity<>(profileSwipeService.likeUser(id, profile_id), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "", response = HttpStatus.class)
    public ResponseEntity<HttpStatus> setPreference(@RequestBody PreferenceDto preferenceDto){
        preferenceService.saveDto(preferenceDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
