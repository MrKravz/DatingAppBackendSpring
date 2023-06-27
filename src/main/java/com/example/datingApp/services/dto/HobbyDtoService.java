package com.example.datingApp.services.dto;

import com.example.datingApp.dtos.HobbyDto;
import com.example.datingApp.mappers.HobbyMapper;
import com.example.datingApp.models.Hobby;
import com.example.datingApp.services.crud.HobbyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class HobbyDtoService implements DtoProviderService<HobbyDto, Hobby> {

    private final HobbyService hobbyService;

    private final HobbyMapper hobbyMapper;

    @Override
    public List<HobbyDto> findAll() {
        return (List<HobbyDto>) hobbyMapper.toIterableDto(hobbyService.findAll());
    }

    @Override
    public HobbyDto findById(int id) {
        return hobbyMapper.toDto(hobbyService.findById(id));
    }

    @Override
    public Hobby save(HobbyDto dto) {
        return hobbyService.save(hobbyMapper.toEntity(dto));
    }

    @Override
    public Hobby update(HobbyDto dto, int id) {
        return hobbyService.update(hobbyMapper.toEntity(dto), id);
    }
}
