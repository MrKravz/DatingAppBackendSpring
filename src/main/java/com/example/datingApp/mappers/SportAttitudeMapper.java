package com.example.datingApp.mappers;

import com.example.datingApp.dtos.SportAttitudeDto;
import com.example.datingApp.models.SportAttitude;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SportAttitudeMapper extends CommonMapper<SportAttitudeDto, SportAttitude>{
}
