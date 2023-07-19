package com.example.datingApp.services;

import com.example.datingApp.exceptions.PictureNotFoundException;
import com.example.datingApp.mappers.PictureMapper;
import com.example.datingApp.models.*;
import com.example.datingApp.repositories.PictureRepository;
import io.trbl.blurhash.BlurHash;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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
        return pictureRepository.findById(id).orElseThrow(PictureNotFoundException::new);
    }

    @Override
    public Picture getPictureById(int id) {
        return findById(id);
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
        pictureToUpdate.setPictureBlurHash(entity.getPictureBlurHash());
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
        // Configure blur hash
        BufferedImage image = ImageIO.read(file.getInputStream());
        String blurHash = BlurHash.encode(image);

        // Save the image information to the database
        Picture picture = new Picture();
        picture.setProfile(user.getProfile());
        picture.setPictureBlurHash(blurHash);
        picture.setPicture(file.getBytes());
        pictureRepository.save(picture);
    }
}
