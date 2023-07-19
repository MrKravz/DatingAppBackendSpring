package com.example.datingApp.services;

import com.example.datingApp.dtos.PetAttitudeDto;
import com.example.datingApp.exceptions.PetAttitudeNotFound;
import com.example.datingApp.mappers.PetAttitudeMapper;
import com.example.datingApp.models.PetAttitude;
import com.example.datingApp.repositories.PetAttitudeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class PetAttitudeService implements CrudService<PetAttitude>, DtoService<PetAttitudeDto, PetAttitude> {

    private final PetAttitudeRepository petAttitudeRepository;
    private final PetAttitudeMapper petAttitudeMapper;

    @Override
    public List<PetAttitude> findAll() {
        return petAttitudeRepository.findAll();
    }

    @Override
    public PetAttitude findById(int id) {
        return petAttitudeRepository.findById(id).orElseThrow(PetAttitudeNotFound::new);
    }

    @Override
    @Transactional
    public PetAttitude save(PetAttitude entity) {
        return petAttitudeRepository.save(entity);
    }

    @Override
    @Transactional
    public PetAttitude update(PetAttitude entity, int id) {
        var petAttitudeToUpdate = findById(id);
        petAttitudeToUpdate.setName(entity.getName());
        return petAttitudeRepository.save(petAttitudeToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        petAttitudeRepository.deleteById(id);
    }

    @Override
    public List<PetAttitudeDto> findAllDto() {
        return petAttitudeMapper.toIterableDto(findAll());
    }

    @Override
    public PetAttitudeDto findDtoById(int id) {
        return petAttitudeMapper.toDto(findById(id));
    }

    @Override
    public PetAttitude saveDto(PetAttitudeDto dto) {
        return save(petAttitudeMapper.toEntity(dto));
    }

    @Override
    public PetAttitude updateDto(PetAttitudeDto dto, int id) {
        return update(petAttitudeMapper.toEntity(dto), id);
    }
}
