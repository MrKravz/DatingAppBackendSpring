package com.example.datingApp.repositories;

import com.example.datingApp.models.SmokingAttitude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmokingAttitudeRepository extends JpaRepository<SmokingAttitude, Integer> {
}
