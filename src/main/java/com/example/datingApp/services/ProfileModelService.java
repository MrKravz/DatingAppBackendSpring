package com.example.datingApp.services;

import com.example.datingApp.dtos.*;
import com.example.datingApp.services.dto.*;
import com.example.datingApp.util.ProfileModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ProfileModelService {

    private final AlcoholAttitudeDtoService alcoholAttitudeDtoService;

    private final CityDtoService cityDtoService;

    private final CountryDtoService countryDtoService;

    private final GoalDtoService goalDtoService;

    private final HobbyDtoService hobbyDtoService;

    private final PetAttitudeDtoService petAttitudeDtoService;

    private final UserDtoService userDtoService;

    private final SmokingAttitudeDtoService smokingAttitudeDtoService;

    private final SportAttitudeDtoService sportAttitudeDtoService;

    private final ZodiacSignDtoService zodiacSignDtoService;

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
