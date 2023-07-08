package com.example.datingApp.repositories;

import com.example.datingApp.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    @Query("SELECT p FROM Profile p WHERE p.user.age > ?1 AND p.user.age < ?2")
    List<Profile> findByAgeGap(int minAge, int maxAge);
}
