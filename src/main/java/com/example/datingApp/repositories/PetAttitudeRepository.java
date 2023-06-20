package com.example.datingApp.repositories;

import com.example.datingApp.models.PetAttitude;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetAttitudeRepository extends ListCrudRepository<PetAttitude, Integer> {
}
