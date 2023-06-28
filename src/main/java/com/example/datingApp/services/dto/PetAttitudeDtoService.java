package com.example.datingApp.services.dto;

import com.example.datingApp.dtos.PetAttitudeDto;
import com.example.datingApp.mappers.PetAttitudeMapper;
import com.example.datingApp.models.PetAttitude;
import com.example.datingApp.services.crud.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PetAttitudeDtoService implements DtoProviderService<PetAttitudeDto, PetAttitude> {

    private final CrudService<PetAttitude> petAttitudeService;

    private final PetAttitudeMapper petAttitudeMapper;

    @Override
    public List<PetAttitudeDto> findAll() {
        return (List<PetAttitudeDto>) petAttitudeMapper.toIterableDto(petAttitudeService.findAll());
    }

    @Override
    public PetAttitudeDto findById(int id) {
        return petAttitudeMapper.toDto(petAttitudeService.findById(id));
    }

    @Override
    public PetAttitude save(PetAttitudeDto dto) {
        return petAttitudeService.save(petAttitudeMapper.toEntity(dto));
    }

    @Override
    public PetAttitude update(PetAttitudeDto dto, int id) {
        return petAttitudeService.update(petAttitudeMapper.toEntity(dto), id);
    }
}
