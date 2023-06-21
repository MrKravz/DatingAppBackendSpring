package com.example.datingApp.mappers;

import com.example.datingApp.dtos.PetAttitudeDto;
import com.example.datingApp.models.PetAttitude;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PetAttitudeMapper extends CommonMapper<PetAttitudeDto, PetAttitude>{
}
