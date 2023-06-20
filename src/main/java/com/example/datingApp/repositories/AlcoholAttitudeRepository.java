package com.example.datingApp.repositories;

import com.example.datingApp.models.AlcoholAttitude;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcoholAttitudeRepository extends ListCrudRepository<AlcoholAttitude, Integer> {
}
