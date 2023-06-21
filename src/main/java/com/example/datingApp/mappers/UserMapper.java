package com.example.datingApp.mappers;

import com.example.datingApp.dtos.UserDto;
import com.example.datingApp.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends CommonMapper<UserDto, User>{
}
