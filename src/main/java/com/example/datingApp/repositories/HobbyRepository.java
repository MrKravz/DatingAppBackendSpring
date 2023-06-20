package com.example.datingApp.repositories;

import com.example.datingApp.models.Hobby;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbyRepository extends ListCrudRepository<Hobby, Integer> {
}
