package com.example.datingApp.services.dto;

import com.example.datingApp.dtos.SportAttitudeDto;
import com.example.datingApp.mappers.SportAttitudeMapper;
import com.example.datingApp.models.SportAttitude;
import com.example.datingApp.services.crud.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SportAttitudeDtoService implements DtoProviderService<SportAttitudeDto, SportAttitude> {
    private final CrudService<SportAttitude> sportAttitudeService;
    private final SportAttitudeMapper sportAttitudeMapper;

    @Override
    public List<SportAttitudeDto> findAll() {
        return (List<SportAttitudeDto>) sportAttitudeMapper.toIterableDto(sportAttitudeService.findAll());
    }

    @Override
    public SportAttitudeDto findById(int id) {
        return sportAttitudeMapper.toDto(sportAttitudeService.findById(id));
    }

    @Override
    public SportAttitude save(SportAttitudeDto dto) {
        return sportAttitudeService.save(sportAttitudeMapper.toEntity(dto));
    }

    @Override
    public SportAttitude update(SportAttitudeDto dto, int id) {
        return sportAttitudeService.update(sportAttitudeMapper.toEntity(dto), id);
    }
}
