package com.example.datingApp.repositories;

import com.example.datingApp.models.PetAttitude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetAttitudeRepository extends JpaRepository<PetAttitude, Integer> {
}
