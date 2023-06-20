package com.example.datingApp.repositories;

import com.example.datingApp.models.Goal;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends ListCrudRepository<Goal, Integer> {
}
