package com.example.datingApp.services;

import com.example.datingApp.models.Profile;
import com.example.datingApp.services.crud.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfileSwipeService {

    private final ProfileService profileService;

    public List<Profile> getSwipeList(int userId) {
        return profileService.findAll().stream().filter(x->x.getId() != userId).toList();
    }
}
