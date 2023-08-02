package com.example.datingApp.mappers;

import com.example.datingApp.dtos.PreferenceDto;
import com.example.datingApp.models.Preference;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class, CountryMapper.class})
public interface PreferenceMapper extends CommonMapper<PreferenceDto, Preference> {
    @Override
    @Mapping(source = "user", target = "userDto")
    @Mapping(source = "country", target = "countryDto")
    PreferenceDto toDto(Preference entity);

    @Override
    @Mapping(source = "userDto", target = "user")
    @Mapping(source = "countryDto", target = "country")
    Preference toEntity(PreferenceDto entity);
}
