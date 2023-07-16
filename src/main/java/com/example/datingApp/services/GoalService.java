package com.example.datingApp.services;

import com.example.datingApp.dtos.GoalDto;
import com.example.datingApp.mappers.GoalMapper;
import com.example.datingApp.models.Goal;
import com.example.datingApp.repositories.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class GoalService implements CrudService<Goal>, DtoService<GoalDto, Goal> {

    private final GoalRepository goalRepository;
    private final GoalMapper goalMapper;

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

    @Override
    public List<GoalDto> findAllDto() {
        return goalMapper.toIterableDto(findAll());
    }

    @Override
    public GoalDto findDtoById(int id) {
        return goalMapper.toDto(findById(id));
    }

    @Override
    public Goal saveDto(GoalDto dto) {
        return save(goalMapper.toEntity(dto));
    }

    @Override
    public Goal updateDto(GoalDto dto, int id) {
        return update(goalMapper.toEntity(dto), id);
    }

}
