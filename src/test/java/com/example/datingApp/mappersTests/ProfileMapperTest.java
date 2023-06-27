package com.example.datingApp.mappersTests;

import com.example.datingApp.dtos.ProfileDto;
import com.example.datingApp.dtos.UserDto;
import com.example.datingApp.mappers.ProfileMapper;
import com.example.datingApp.models.Profile;
import com.example.datingApp.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProfileMapperTest {

    @Autowired
    private ProfileMapper profileMapper;

    @Test
    public void profileToDtoTest() {
        User user = new User();
        user.setName("TestUser");
        Profile profile = new Profile();
        profile.setUser(user);
        ProfileDto profileDto = profileMapper.toDto(profile);
        assertTrue(profileDto.userDto().name() == profile.getUser().getName());
    }

    @Test
    public void profileDtoToEntityTest() {
        UserDto userDto = new UserDto("TestUser", new Date(System.currentTimeMillis()), "test@email.com");
        ProfileDto profileDto = new ProfileDto(0,"",userDto,
                null, null, null,
                null, null, null,
                null, null,null);
        Profile profile = profileMapper.toEntity(profileDto);
        assertTrue(profileDto.userDto().name() == profile.getUser().getName());
    }

    @Test
    public void profileListToDtoListTest() {
        User firstUser = new User();
        firstUser.setName("TestUser1");
        Profile firstProfile = new Profile();
        firstProfile.setUser(firstUser);
        User secondUser = new User();
        secondUser.setName("TestUser2");
        Profile secondProfile = new Profile();
        secondProfile.setUser(secondUser);
        List<Profile> profileList = new ArrayList<>();
        profileList.add(firstProfile);
        profileList.add(secondProfile);
        List<ProfileDto> profileDtoList = (List<ProfileDto>) profileMapper.toIterableDto(profileList);
        assertTrue(profileDtoList.get(0).userDto().name() == profileList.get(0).getUser().getName());
        assertTrue(profileDtoList.get(1).userDto().name() == profileList.get(1).getUser().getName());
    }

    @Test
    public void profileDtoListToEntityListTest() {
        UserDto firstUserDto = new UserDto("TestUser1", new Date(System.currentTimeMillis()), "test1@email.com");
        ProfileDto firstProfileDto = new ProfileDto(0,"",firstUserDto,
                null, null, null,
                null, null, null,
                null, null,null);
        UserDto secondUserDto = new UserDto("TestUser2", new Date(System.currentTimeMillis()), "test2@email.com");
        ProfileDto secondProfileDto = new ProfileDto(0,"",secondUserDto,
                null, null, null,
                null, null, null,
                null, null,null);
        List<ProfileDto> profileDtoList = new ArrayList<>();
        profileDtoList.add(firstProfileDto);
        profileDtoList.add(secondProfileDto);
        List<Profile> profileList = (List<Profile>) profileMapper.toIterableEntity(profileDtoList);
        assertTrue(profileDtoList.get(0).userDto().name() == profileList.get(0).getUser().getName());
        assertTrue(profileDtoList.get(1).userDto().name() == profileList.get(1).getUser().getName());
    }
}
