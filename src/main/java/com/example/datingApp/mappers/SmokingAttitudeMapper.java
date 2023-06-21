package com.example.datingApp.mappers;

import com.example.datingApp.dtos.SmokingAttitudeDto;
import com.example.datingApp.models.SmokingAttitude;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SmokingAttitudeMapper extends CommonMapper<SmokingAttitudeDto, SmokingAttitude> {
}
