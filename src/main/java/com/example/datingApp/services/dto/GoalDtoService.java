package com.example.datingApp.services.dto;

import com.example.datingApp.dtos.GoalDto;
import com.example.datingApp.mappers.GoalMapper;
import com.example.datingApp.models.Goal;
import com.example.datingApp.services.crud.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GoalDtoService implements DtoProviderService<GoalDto, Goal> {
    private final GoalService goalService;

    private final GoalMapper goalMapper;

    @Override
    public List<GoalDto> findAll() {
        return (List<GoalDto>) goalMapper.toIterableDto(goalService.findAll());
    }

    @Override
    public GoalDto findById(int id) {
        return goalMapper.toDto(goalService.findById(id));
    }

    @Override
    public Goal save(GoalDto dto) {
        return goalService.save(goalMapper.toEntity(dto));
    }

    @Override
    public Goal update(GoalDto dto, int id) {
        return goalService.update(goalMapper.toEntity(dto), id);
    }
}
