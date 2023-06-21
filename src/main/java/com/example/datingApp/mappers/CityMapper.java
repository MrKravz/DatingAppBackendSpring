package com.example.datingApp.mappers;

import com.example.datingApp.dtos.CityDto;
import com.example.datingApp.models.City;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityMapper extends CommonMapper<CityDto, City>{
}
