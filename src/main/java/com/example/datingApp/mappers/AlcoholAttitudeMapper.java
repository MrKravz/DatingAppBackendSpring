package com.example.datingApp.mappers;

import com.example.datingApp.dtos.AlcoholAttitudeDto;
import com.example.datingApp.models.AlcoholAttitude;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlcoholAttitudeMapper extends CommonMapper<AlcoholAttitudeDto, AlcoholAttitude>{
}
