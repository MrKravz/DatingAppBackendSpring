package com.example.datingApp.servicesTests;

import com.example.datingApp.exceptions.ProfileNotFoundException;
import com.example.datingApp.services.crud.ProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ProfileServiceTest {

    @Autowired
    private ProfileService profileService;

    @Test
    void findAllProfilesTest()
    {
        assertTrue(profileService.findAll() != null && !profileService.findAll().isEmpty());
    }

    @Test
    void findAllByExistingIdTest()
    {
        assertTrue(profileService.findById(1) != null);
    }

    @Test
    void findAllByNotExistingIdTest()
    {
        assertThrows(ProfileNotFoundException.class,() -> {
            profileService.findById(-1);
        });
    }

    @Test
    void saveProfileTest()
    {
        //TODO write test
    }

    @Test
    void updateProfileTest()
    {
        //TODO write test
    }

    @Test
    void deleteProfileTest()
    {
        //TODO write test
    }
}
