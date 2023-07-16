package com.example.datingApp.services;

import com.example.datingApp.dtos.*;
import com.example.datingApp.models.*;
import com.example.datingApp.util.ProfileModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ModelProviderService implements UserModelProviderService, ProfileModelProviderService {

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

    @Override
    public ProfileModel configureProfileModel(int userId)
    {
        var user = userDtoService.findDtoById(userId);
        return new ProfileModel(emptyProfileDto(user), countryDtoService.findAllDto(), cityDtoService.findAllDto(),
                goalDtoService.findAllDto(), zodiacSignDtoService.findAllDto(), sportAttitudeDtoService.findAllDto(),
                alcoholAttitudeDtoService.findAllDto(), smokingAttitudeDtoService.findAllDto(), petAttitudeDtoService.findAllDto(),
                hobbyDtoService.findAllDto());
    }

    @Override
    public UserDto configureUserModel()
    {
        return new UserDto(0,"",18,"", Collections.emptyList());
    }

    private ProfileDto emptyProfileDto(UserDto userDto)
    {
        return new ProfileDto(0,0, null, "", userDto,
                null, null, null,
                null, null, null,
                null, null,null);
    }
}
