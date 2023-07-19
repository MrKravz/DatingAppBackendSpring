package com.example.datingApp.services;

import com.example.datingApp.models.Picture;
import com.example.datingApp.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PictureProviderService {

    void uploadPicture(MultipartFile file, User user) throws IOException;
    Picture getPictureById(int id);

}
