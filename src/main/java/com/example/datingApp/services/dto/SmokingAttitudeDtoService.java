package com.example.datingApp.services.dto;

import com.example.datingApp.dtos.SmokingAttitudeDto;
import com.example.datingApp.mappers.SmokingAttitudeMapper;
import com.example.datingApp.models.SmokingAttitude;
import com.example.datingApp.services.crud.SmokingAttitudeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class SmokingAttitudeDtoService implements DtoProviderService<SmokingAttitudeDto, SmokingAttitude> {

    private final SmokingAttitudeService smokingAttitudeService;

    private final SmokingAttitudeMapper smokingAttitudeMapper;

    @Override
    public List<SmokingAttitudeDto> findAll() {
        return (List<SmokingAttitudeDto>) smokingAttitudeMapper.toIterableDto(smokingAttitudeService.findAll());
    }

    @Override
    public SmokingAttitudeDto findById(int id) {
        return smokingAttitudeMapper.toDto(smokingAttitudeService.findById(id));
    }

    @Override
    public SmokingAttitude save(SmokingAttitudeDto dto) {
        return smokingAttitudeService.save(smokingAttitudeMapper.toEntity(dto));
    }

    @Override
    public SmokingAttitude update(SmokingAttitudeDto dto, int id) {
        return smokingAttitudeService.update(smokingAttitudeMapper.toEntity(dto), id);
    }
}
