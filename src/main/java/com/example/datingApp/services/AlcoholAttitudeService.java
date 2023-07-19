package com.example.datingApp.services;

import com.example.datingApp.dtos.AlcoholAttitudeDto;
import com.example.datingApp.exceptions.AlcoholAttitudeNotFound;
import com.example.datingApp.mappers.AlcoholAttitudeMapper;
import com.example.datingApp.models.AlcoholAttitude;
import com.example.datingApp.repositories.AlcoholAttitudeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class AlcoholAttitudeService implements CrudService<AlcoholAttitude>, DtoService<AlcoholAttitudeDto, AlcoholAttitude> {

    private final AlcoholAttitudeRepository alcoholAttitudeRepository;
    private final AlcoholAttitudeMapper alcoholAttitudeMapper;

    @Override
    public List<AlcoholAttitude> findAll() {
        return alcoholAttitudeRepository.findAll();
    }

    @Override
    public AlcoholAttitude findById(int id) {
        return alcoholAttitudeRepository.findById(id).orElseThrow(AlcoholAttitudeNotFound::new);
    }

    @Override
    @Transactional
    public AlcoholAttitude save(AlcoholAttitude entity) {
        return alcoholAttitudeRepository.save(entity);
    }

    @Override
    @Transactional
    public AlcoholAttitude update(AlcoholAttitude entity, int id) {
        var alcoholAttitudeToUpdate = findById(id);
        alcoholAttitudeToUpdate.setName(entity.getName());
        return alcoholAttitudeRepository.save(alcoholAttitudeToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        alcoholAttitudeRepository.deleteById(id);
    }

    @Override
    public List<AlcoholAttitudeDto> findAllDto() {
        return alcoholAttitudeMapper.toIterableDto(findAll());
    }

    @Override
    public AlcoholAttitudeDto findDtoById(int id) {
        return alcoholAttitudeMapper.toDto(findById(id));
    }

    @Override
    public AlcoholAttitude saveDto(AlcoholAttitudeDto dto) {
        return save(alcoholAttitudeMapper.toEntity(dto));
    }

    @Override
    public AlcoholAttitude updateDto(AlcoholAttitudeDto dto, int id) {
        return update(alcoholAttitudeMapper.toEntity(dto), id);
    }
}
