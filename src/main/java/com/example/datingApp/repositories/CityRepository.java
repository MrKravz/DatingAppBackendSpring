package com.example.datingApp.repositories;

import com.example.datingApp.models.City;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends ListCrudRepository<City, Integer> {
}
