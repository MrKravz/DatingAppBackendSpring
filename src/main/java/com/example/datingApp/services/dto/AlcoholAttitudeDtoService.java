package com.example.datingApp.services.dto;

import com.example.datingApp.dtos.AlcoholAttitudeDto;
import com.example.datingApp.mappers.AlcoholAttitudeMapper;
import com.example.datingApp.models.AlcoholAttitude;
import com.example.datingApp.services.crud.AlcoholAttitudeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AlcoholAttitudeDtoService implements DtoProviderService<AlcoholAttitudeDto, AlcoholAttitude> {

    private final AlcoholAttitudeService alcoholAttitudeService;

    private final AlcoholAttitudeMapper alcoholAttitudeMapper;

    @Override
    public List<AlcoholAttitudeDto> findAll() {
        return (List<AlcoholAttitudeDto>) alcoholAttitudeMapper.toIterableDto(alcoholAttitudeService.findAll());
    }

    @Override
    public AlcoholAttitudeDto findById(int id) {
        return alcoholAttitudeMapper.toDto(alcoholAttitudeService.findById(id));
    }

    @Override
    public AlcoholAttitude save(AlcoholAttitudeDto dto) {
        return alcoholAttitudeService.save(alcoholAttitudeMapper.toEntity(dto));
    }

    @Override
    public AlcoholAttitude update(AlcoholAttitudeDto dto, int id) {
        return alcoholAttitudeService.update(alcoholAttitudeMapper.toEntity(dto), id);
    }
}
