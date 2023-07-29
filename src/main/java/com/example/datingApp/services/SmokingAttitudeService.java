package com.example.datingApp.services;

import com.example.datingApp.dtos.SmokingAttitudeDto;
import com.example.datingApp.exceptions.SmokingAttitudeNotFound;
import com.example.datingApp.mappers.SmokingAttitudeMapper;
import com.example.datingApp.models.SmokingAttitude;
import com.example.datingApp.repositories.SmokingAttitudeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class SmokingAttitudeService implements CrudService<SmokingAttitude>, DtoService<SmokingAttitudeDto, SmokingAttitude> {

    private final SmokingAttitudeRepository smokingAttitudeRepository;
    private final SmokingAttitudeMapper smokingAttitudeMapper;

    @Override
    public List<SmokingAttitude> findAll() {
        return smokingAttitudeRepository.findAll();
    }

    @Override
    public SmokingAttitude findById(int id) {
        return smokingAttitudeRepository.findById(id).orElseThrow(SmokingAttitudeNotFound::new);
    }

    @Override
    @Transactional
    public SmokingAttitude save(SmokingAttitude entity) {
        return smokingAttitudeRepository.save(entity);
    }

    @Override
    @Transactional
    public SmokingAttitude update(SmokingAttitude entity, int id) {
        var smokingAttitudeToUpdate = findById(id);
        smokingAttitudeToUpdate.setName(entity.getName());
        return smokingAttitudeRepository.save(smokingAttitudeToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        smokingAttitudeRepository.deleteById(id);
    }

    @Override
    public List<SmokingAttitudeDto> findAllDto() {
        return smokingAttitudeMapper.toListDto(findAll());
    }

    @Override
    public SmokingAttitudeDto findDtoById(int id) {
        return smokingAttitudeMapper.toDto(findById(id));
    }

    @Override
    public SmokingAttitude saveDto(SmokingAttitudeDto dto) {
        return save(smokingAttitudeMapper.toEntity(dto));
    }

    @Override
    public SmokingAttitude updateDto(SmokingAttitudeDto dto, int id) {
        return update(smokingAttitudeMapper.toEntity(dto), id);
    }
}
