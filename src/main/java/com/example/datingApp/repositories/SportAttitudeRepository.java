package com.example.datingApp.repositories;

import com.example.datingApp.models.SportAttitude;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportAttitudeRepository extends ListCrudRepository<SportAttitude, Integer> {
}
