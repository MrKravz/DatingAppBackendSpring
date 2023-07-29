package com.example.datingApp.mappers;

import com.example.datingApp.dtos.ProfileDto;
import com.example.datingApp.models.Profile;
import org.mapstruct.*;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class, CityMapper.class,
        GoalMapper.class, HobbyMapper.class, PetAttitudeMapper.class,
        SmokingAttitudeMapper.class, SportAttitudeMapper.class, AlcoholAttitudeMapper.class, PictureMapper.class})
public interface ProfileMapper extends CommonMapper<ProfileDto, Profile>{
    @Override
    @Mapping(source = "user", target = "userDto")
    @Mapping(source = "city", target = "cityDto")
    @Mapping(source = "goal", target = "goalDto")
    @Mapping(source = "hobbies", target = "hobbyDtoList")
    @Mapping(source = "sportAttitude", target = "sportAttitudeDto")
    @Mapping(source = "alcoholAttitude", target = "alcoholAttitudeDto")
    @Mapping(source = "smokingAttitude", target = "smokingAttitudeDto")
    @Mapping(source = "petAttitude", target = "petAttitudeDto")
    @Mapping(source = "zodiacSign", target = "zodiacSignDto")
    @Mapping(source = "pictures", target = "pictureDtoList")
    ProfileDto toDto(Profile entity);

    @Override
    @Mapping(source = "userDto", target = "user")
    @Mapping(source = "cityDto", target = "city")
    @Mapping(source = "goalDto", target = "goal")
    @Mapping(source = "hobbyDtoList", target = "hobbies")
    @Mapping(source = "sportAttitudeDto", target = "sportAttitude")
    @Mapping(source = "alcoholAttitudeDto", target = "alcoholAttitude")
    @Mapping(source = "smokingAttitudeDto", target = "smokingAttitude")
    @Mapping(source = "petAttitudeDto", target = "petAttitude")
    @Mapping(source = "zodiacSignDto", target = "zodiacSign")
    @Mapping(source = "pictureDtoList", target = "pictures")
    Profile toEntity(ProfileDto entity);
}
