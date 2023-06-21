package com.example.datingApp.mappers;

import com.example.datingApp.dtos.ProfileDto;
import com.example.datingApp.models.Profile;
import org.mapstruct.*;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class, CityMapper.class, CountryMapper.class,
        GoalMapper.class, HobbyMapper.class, PetAttitudeMapper.class,
        SmokingAttitudeMapper.class, SportAttitudeMapper.class, AlcoholAttitudeMapper.class})
public interface ProfileMapper extends CommonMapper<ProfileDto, Profile>{
}
