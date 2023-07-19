package com.example.datingApp.services;

import com.example.datingApp.dtos.SportAttitudeDto;
import com.example.datingApp.exceptions.SportAttitudeNotFound;
import com.example.datingApp.mappers.SportAttitudeMapper;
import com.example.datingApp.models.SportAttitude;
import com.example.datingApp.repositories.SportAttitudeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class SportAttitudeService implements CrudService<SportAttitude>, DtoService<SportAttitudeDto, SportAttitude> {

    private final SportAttitudeRepository sportAttitudeRepository;
    private final SportAttitudeMapper sportAttitudeMapper;

    @Override
    public List<SportAttitude> findAll() {
        return sportAttitudeRepository.findAll();
    }

    @Override
    public SportAttitude findById(int id) {
        return sportAttitudeRepository.findById(id).orElseThrow(SportAttitudeNotFound::new);
    }

    @Override
    @Transactional
    public SportAttitude save(SportAttitude entity) {
        return sportAttitudeRepository.save(entity);
    }

    @Override
    @Transactional
    public SportAttitude update(SportAttitude entity, int id) {
        var sportAttitudeToUpdate = findById(id);
        sportAttitudeToUpdate.setName(entity.getName());
        return sportAttitudeRepository.save(sportAttitudeToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        sportAttitudeRepository.deleteById(id);
    }

    @Override
    public List<SportAttitudeDto> findAllDto() {
        return sportAttitudeMapper.toIterableDto(findAll());
    }

    @Override
    public SportAttitudeDto findDtoById(int id) {
        return sportAttitudeMapper.toDto(findById(id));
    }

    @Override
    public SportAttitude saveDto(SportAttitudeDto dto) {
        return save(sportAttitudeMapper.toEntity(dto));
    }

    @Override
    public SportAttitude updateDto(SportAttitudeDto dto, int id) {
        return update(sportAttitudeMapper.toEntity(dto), id);
    }
}
