package com.example.datingApp.mappers;

import com.example.datingApp.dtos.PictureDto;
import com.example.datingApp.models.Picture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PictureMapper extends CommonMapper<PictureDto, Picture> {
    @Mapping(target = "imageLink", expression = "java(generateImageLink(picture.getProfile().getUser().getId()," +
            " picture.getId()))")
    @Mapping(source = "pictureBlurHash", target = "blurHash")
    @Override
    PictureDto toDto(Picture picture);

    default String generateImageLink(int userId, int pictureId) {
        return String.format("http://localhost:8080/user/%d/pictures/%d", userId, pictureId);
    }
}
