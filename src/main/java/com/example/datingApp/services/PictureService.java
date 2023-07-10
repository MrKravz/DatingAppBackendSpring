package com.example.datingApp.services;

import com.example.datingApp.models.Picture;
import com.example.datingApp.models.User;
import com.example.datingApp.repositories.PictureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class PictureService implements CrudService<Picture>, PictureProviderService {

    private final PictureRepository pictureRepository;

    @Override
    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Picture findById(int id) {
        return pictureRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public Picture save(Picture entity) {
        return pictureRepository.save(entity);
    }

    @Override
    @Transactional
    public Picture update(Picture entity, int id) {
        var pictureToUpdate = findById(id);
        pictureToUpdate.setPicture(entity.getPicture());
        return pictureRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(int id) {
        pictureRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void uploadPicture(MultipartFile file, User user) throws IOException {
        try {
            Picture picture = new Picture();
            picture.setProfile(user.getProfile());
            picture.setPicture(file.getBytes());
            pictureRepository.save(picture);
        } catch (IOException ex) {
            throw new IOException();
        }
    }
}
