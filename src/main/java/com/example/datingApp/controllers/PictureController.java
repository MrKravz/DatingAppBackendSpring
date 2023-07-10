package com.example.datingApp.controllers;

import com.example.datingApp.exceptions.ProfilesNotFoundException;
import com.example.datingApp.models.User;
import com.example.datingApp.services.CrudService;
import com.example.datingApp.services.PictureProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("user/{id}/pictures")
@AllArgsConstructor
@Api(value = "Picture controller")
public class PictureController {

    private final PictureProviderService pictureService;
    private final CrudService<User> userService;

    @PostMapping
    @ApiOperation(value = "Upload a new picture to profile", response = HttpStatus.class)
    public ResponseEntity<HttpStatus> uploadPicture(@PathVariable("id") int id,
                                                @RequestBody MultipartFile file) throws IOException {
            pictureService.uploadPicture(file, userService.findById(id));
            return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler(IOException.class)
    private ResponseEntity<?> handleIOException(ProfilesNotFoundException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload picture.");
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get picture by id", response = byte[].class)
    public ResponseEntity<byte[]> getPicture(@PathVariable int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(pictureService.findById(id).getPicture(), headers, HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class) // TODO change to Picture not found ex
    private ResponseEntity<?> handlePictureNotFoundException(ProfilesNotFoundException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload picture.");
    }
}
