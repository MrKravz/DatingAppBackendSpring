package com.example.datingApp.repositories;

import com.example.datingApp.models.SmokingAttitude;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmokingAttitudeRepository extends ListCrudRepository<SmokingAttitude, Integer> {
}
