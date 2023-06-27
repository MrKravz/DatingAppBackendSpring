package com.example.datingApp.controllers;

import com.example.datingApp.dtos.ProfileDto;
import com.example.datingApp.mappers.ProfileMapper;
import com.example.datingApp.services.ProfileSwipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/{id}")
@AllArgsConstructor
public class MainController {

    private final ProfileSwipeService profileSwipeService;

    private final ProfileMapper profileMapper;

    @GetMapping
    public ResponseEntity<List<ProfileDto>> getProfiles(@PathVariable("id") int id){
        return new ResponseEntity<>((List<ProfileDto>) profileMapper.toIterableDto(profileSwipeService.getSwipeList(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProfileDto>> likeProfile(@PathVariable("id") int id){
        return new ResponseEntity<>((List<ProfileDto>) profileMapper.toIterableDto(profileSwipeService.getSwipeList(id)), HttpStatus.OK);
    }
}
