package com.example.datingApp.services.crud;

import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.models.Goal;
import com.example.datingApp.repositories.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class GoalService implements CrudService<Goal> {

    private final GoalRepository goalRepository;

    @Override
    public List<Goal> findAll() {
        return goalRepository.findAll();
    }

    @Override
    public Goal findById(int id) {
        return goalRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public Goal save(Goal entity) {
        return goalRepository.save(entity);
    }

    @Override
    @Transactional
    public Goal update(Goal entity, int id) {
        var goalToUpdate = findById(id);
        goalToUpdate.setName(entity.getName());
        return goalRepository.save(goalToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        goalRepository.deleteById(id);
    }
}
