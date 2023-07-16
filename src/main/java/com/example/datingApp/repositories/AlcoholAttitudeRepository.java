package com.example.datingApp.repositories;

import com.example.datingApp.models.AlcoholAttitude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcoholAttitudeRepository extends JpaRepository<AlcoholAttitude, Integer> {
}
