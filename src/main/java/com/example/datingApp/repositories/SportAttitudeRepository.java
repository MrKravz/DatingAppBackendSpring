package com.example.datingApp.repositories;

import com.example.datingApp.models.SportAttitude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportAttitudeRepository extends JpaRepository<SportAttitude, Integer> {
}
