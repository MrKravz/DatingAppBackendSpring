package com.example.datingApp.dtos;

import com.example.datingApp.models.Gender;

import java.util.List;

public record ProfileDto(int id,
                         int height,
                         Gender gender,
                         String about,
                         UserDto userDto,
                         CountryDto countryDto,
                         CityDto cityDto,
                         ZodiacSignDto zodiacSignDto,
                         GoalDto goalDto,
                         SportAttitudeDto sportAttitudeDto,
                         AlcoholAttitudeDto alcoholAttitudeDto,
                         SmokingAttitudeDto smokingAttitudeDto,
                         PetAttitudeDto petAttitudeDto,
                         List<HobbyDto> hobbyDtoList) {
    // TODO change dto
}
