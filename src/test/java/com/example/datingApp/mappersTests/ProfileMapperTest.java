package com.example.datingApp.mappersTests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.datingApp.dtos.*;
import com.example.datingApp.mappers.*;
import com.example.datingApp.models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;

@SpringBootTest
public class ProfileMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private GoalMapper goalMapper;

    @Autowired
    private HobbyMapper hobbyMapper;

    @Autowired
    private PetAttitudeMapper petAttitudeMapper;

    @Autowired
    private SmokingAttitudeMapper smokingAttitudeMapper;

    @Autowired
    private SportAttitudeMapper sportAttitudeMapper;

    @Autowired
    private AlcoholAttitudeMapper alcoholAttitudeMapper;

    @Autowired
    private ProfileMapper profileMapper;

    @Test
    public void testToDto() {
        Goal goal = new Goal();
        goal.setId(1);
        goal.setName("GG");
        goal.setProfiles(Collections.emptyList());
        GoalDto goalDto = goalMapper.toDto(goal);
        assertTrue(goalDto.name() == goal.getName());
    }
}
