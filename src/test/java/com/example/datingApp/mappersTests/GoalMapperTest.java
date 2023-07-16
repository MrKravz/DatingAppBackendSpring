package com.example.datingApp.mappersTests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.datingApp.dtos.*;
import com.example.datingApp.mappers.*;
import com.example.datingApp.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class GoalMapperTest {

    @Autowired
    private GoalMapper goalMapper;

    @Test
    public void goalToDtoTest() {
        Goal goal = new Goal();
        goal.setId(1);
        goal.setName("GG");
        goal.setProfiles(Collections.emptyList());
        GoalDto goalDto = goalMapper.toDto(goal);
        assertTrue(goalDto.name() == goal.getName());
    }

    @Test
    public void goalDtoToEntityTest() {
        GoalDto goalDto = new GoalDto("GG");
        Goal goal = goalMapper.toEntity(goalDto);
        assertTrue(goalDto.name() == goal.getName());
    }

    @Test
    public void goalListToDtoListTest() {
        Goal fGoal = new Goal();
        fGoal.setName("G1");
        Goal sGoal = new Goal();
        sGoal.setName("G2");
        List<Goal> goalList = new ArrayList<>();
        goalList.add(fGoal);
        goalList.add(sGoal);
        List<GoalDto> goalDtoList = (List<GoalDto>) goalMapper.toIterableDto(goalList);
        assertTrue(goalDtoList.get(0).name() == goalList.get(0).getName());
        assertTrue(goalDtoList.get(1).name() == goalList.get(1).getName());
    }

    @Test
    public void goalDtoListToEntityListTest() {
        GoalDto fGoalDto = new GoalDto("G1");
        GoalDto sGoalDto = new GoalDto("G2");
        List<GoalDto> goalDtoList = new ArrayList<>();
        goalDtoList.add(fGoalDto);
        goalDtoList.add(sGoalDto);
        List<Goal> goalList = (List<Goal>) goalMapper.toIterableEntity(goalDtoList);
        assertTrue(goalDtoList.get(0).name() == goalList.get(0).getName());
        assertTrue(goalDtoList.get(1).name() == goalList.get(1).getName());
    }
}
