package com.example.datingApp.services;

import com.example.datingApp.models.Profile;

import java.util.List;

public interface FindByPreferenceService {
    List<Profile> findByAgeGap(int minAge, int maxAge);
}
