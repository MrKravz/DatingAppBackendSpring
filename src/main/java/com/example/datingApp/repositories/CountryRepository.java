package com.example.datingApp.repositories;

import com.example.datingApp.models.Country;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends ListCrudRepository<Country, Integer> {
}
