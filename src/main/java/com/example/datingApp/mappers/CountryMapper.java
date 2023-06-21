package com.example.datingApp.mappers;

import com.example.datingApp.dtos.CountryDto;
import com.example.datingApp.models.Country;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryMapper extends CommonMapper<CountryDto, Country>{
}
