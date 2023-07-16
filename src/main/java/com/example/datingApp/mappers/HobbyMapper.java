package com.example.datingApp.mappers;

import com.example.datingApp.dtos.HobbyDto;
import com.example.datingApp.models.Hobby;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HobbyMapper extends CommonMapper<HobbyDto, Hobby>{
}
