package com.example.datingApp.controllers;

import com.example.datingApp.models.Picture;
import com.example.datingApp.services.PictureService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/pictures")
@AllArgsConstructor
public class PictureController {

    private final PictureService picturesRepository;

    @PostMapping
    public ResponseEntity<String> uploadPicture(@RequestParam("file") MultipartFile file) {
        try {
            Picture picture = new Picture();
            picture.setPicture(file.getBytes());
            picturesRepository.save(picture);
            return ResponseEntity.ok("Picture uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload picture.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getPicture(@PathVariable int id) {
        Picture picture = picturesRepository.findById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(picture.getPicture(), headers, HttpStatus.OK);
    }

}
