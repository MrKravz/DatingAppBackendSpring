package com.example.datingApp.repositories;

import com.example.datingApp.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findByUserName(String name);
}
