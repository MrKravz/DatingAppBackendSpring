package com.example.datingApp.services;

import com.example.datingApp.dtos.*;
import com.example.datingApp.models.*;
import com.example.datingApp.util.ProfileModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ProfileModelService {

    private final DtoService<AlcoholAttitudeDto, AlcoholAttitude> alcoholAttitudeDtoService;
    private final DtoService<CityDto, City> cityDtoService;
    private final DtoService<CountryDto, Country> countryDtoService;
    private final DtoService<GoalDto, Goal> goalDtoService;
    private final DtoService<HobbyDto, Hobby> hobbyDtoService;
    private final DtoService<PetAttitudeDto, PetAttitude> petAttitudeDtoService;
    private final DtoService<UserDto, User> userDtoService;
    private final DtoService<SmokingAttitudeDto, SmokingAttitude> smokingAttitudeDtoService;
    private final DtoService<SportAttitudeDto, SportAttitude> sportAttitudeDtoService;
    private final DtoService<ZodiacSignDto, ZodiacSign> zodiacSignDtoService;

    public ProfileModel configureModel(int userId)
    {
        var user = userDtoService.findDtoById(userId);
        return new ProfileModel(emptyProfileDto(user), countryDtoService.findAllDto(), cityDtoService.findAllDto(),
                goalDtoService.findAllDto(), zodiacSignDtoService.findAllDto(), sportAttitudeDtoService.findAllDto(),
                alcoholAttitudeDtoService.findAllDto(), smokingAttitudeDtoService.findAllDto(), petAttitudeDtoService.findAllDto(),
                hobbyDtoService.findAllDto());
    }

    private ProfileDto emptyProfileDto(UserDto userDto)
    {
        return new ProfileDto(0, null, "", userDto,
                null, null, null,
                null, null, null,
                null, null,null);
    }
}
