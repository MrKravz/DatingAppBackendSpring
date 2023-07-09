package com.example.datingApp.util;

import com.example.datingApp.dtos.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class ProfileModel {

    private ProfileDto profileDto;

    private List<CountryDto> countryDtoList;

    private List<CityDto> cityDtoList;

    private List<GoalDto> goalDtoList;

    private List<ZodiacSignDto> zodiacSignDtoList;

    private List<SportAttitudeDto> sportAttitudeDtoList;

    private List<AlcoholAttitudeDto> alcoholAttitudeDtoList;

    private List<SmokingAttitudeDto> smokingAttitudeDtoList;

    private List<PetAttitudeDto> petAttitudeDtoList;

    private List<HobbyDto> hobbyDtoList;

}
