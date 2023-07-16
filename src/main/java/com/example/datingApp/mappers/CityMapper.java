package com.example.datingApp.mappers;

import com.example.datingApp.dtos.CityDto;
import com.example.datingApp.models.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,  uses = {CountryMapper.class})
public interface CityMapper extends CommonMapper<CityDto, City>{
    @Override
    @Mapping(source = "country", target = "countryDto")
    CityDto toDto(City entity);

    @Override
    @Mapping(source = "countryDto", target = "country")
    City toEntity(CityDto entity);
}
