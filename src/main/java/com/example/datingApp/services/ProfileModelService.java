package com.example.datingApp.services;

import com.example.datingApp.dtos.*;
import com.example.datingApp.models.*;
import com.example.datingApp.services.dto.*;
import com.example.datingApp.util.ProfileModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ProfileModelService {

    private final DtoProviderService<AlcoholAttitudeDto, AlcoholAttitude> alcoholAttitudeDtoService;

    private final DtoProviderService<CityDto, City> cityDtoService;

    private final DtoProviderService<CountryDto, Country> countryDtoService;

    private final DtoProviderService<GoalDto, Goal> goalDtoService;

    private final DtoProviderService<HobbyDto, Hobby> hobbyDtoService;

    private final DtoProviderService<PetAttitudeDto, PetAttitude> petAttitudeDtoService;

    private final DtoProviderService<UserDto, User> userDtoService;

    private final DtoProviderService<SmokingAttitudeDto, SmokingAttitude> smokingAttitudeDtoService;

    private final DtoProviderService<SportAttitudeDto, SportAttitude> sportAttitudeDtoService;

    private final DtoProviderService<ZodiacSignDto, ZodiacSign> zodiacSignDtoService;

    public ProfileModel configureModel(int userId)
    {
        var user = userDtoService.findById(userId);
        return new ProfileModel(emptyProfileDto(user), countryDtoService.findAll(), cityDtoService.findAll(),
                goalDtoService.findAll(), zodiacSignDtoService.findAll(), sportAttitudeDtoService.findAll(),
                alcoholAttitudeDtoService.findAll(), smokingAttitudeDtoService.findAll(), petAttitudeDtoService.findAll(),
                hobbyDtoService.findAll());
    }

    private ProfileDto emptyProfileDto(UserDto userDto)
    {
        return new ProfileDto(0,"", userDto,
                null, null, null,
                null, null, null,
                null, null,null);
    }
}
