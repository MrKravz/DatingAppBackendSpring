package com.example.datingApp.dtos;

import java.util.List;

public record ProfileDto(int height,
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
}
