package com.example.datingApp.mappers;

import com.example.datingApp.dtos.GoalDto;
import com.example.datingApp.models.Goal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GoalMapper extends CommonMapper<GoalDto, Goal>{
}
