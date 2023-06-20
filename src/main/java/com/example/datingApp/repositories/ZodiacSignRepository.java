package com.example.datingApp.repositories;

import com.example.datingApp.models.ZodiacSign;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZodiacSignRepository extends ListCrudRepository<ZodiacSign, Integer> {
}
