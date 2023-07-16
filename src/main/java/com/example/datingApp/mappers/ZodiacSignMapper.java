package com.example.datingApp.mappers;

import com.example.datingApp.dtos.ZodiacSignDto;
import com.example.datingApp.models.ZodiacSign;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ZodiacSignMapper extends CommonMapper<ZodiacSignDto, ZodiacSign>{
}
