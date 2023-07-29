package com.example.datingApp.dtos;

import com.example.datingApp.models.Gender;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value = "Profile dto")
public record ProfileDto(int id,
                         int height,
                         Gender gender,
                         String about,
                         UserDto userDto,
                         CityDto cityDto,
                         ZodiacSignDto zodiacSignDto,
                         GoalDto goalDto,
                         SportAttitudeDto sportAttitudeDto,
                         AlcoholAttitudeDto alcoholAttitudeDto,
                         SmokingAttitudeDto smokingAttitudeDto,
                         PetAttitudeDto petAttitudeDto,
                         List<HobbyDto> hobbyDtoList,
                         List<PictureDto> pictureDtoList) {
}
