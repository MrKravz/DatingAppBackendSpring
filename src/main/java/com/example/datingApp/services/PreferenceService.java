package com.example.datingApp.services;

import com.example.datingApp.dtos.PreferenceDto;
import com.example.datingApp.mappers.PreferenceMapper;
import com.example.datingApp.models.Preference;
import com.example.datingApp.repositories.PreferenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PreferenceService implements CrudService<Preference>, DtoService<PreferenceDto, Preference> {

    private final PreferenceRepository preferenceRepository;
    private final PreferenceMapper preferenceMapper;

    @Override
    public List<Preference> findAll() {
        return preferenceRepository.findAll();
    }

    @Override
    public Preference findById(int id) {
        return preferenceRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public Preference save(Preference entity) {
        return preferenceRepository.save(entity);
    }

    @Override
    @Transactional
    public Preference update(Preference entity, int id) {
        var preferenceToUpdate = findById(id);
        preferenceToUpdate.setCountry(entity.getCountry());
        preferenceToUpdate.setGender(entity.getGender());
        preferenceToUpdate.setMaxAge(entity.getMaxAge());
        preferenceToUpdate.setMinAge(entity.getMinAge());
        return preferenceRepository.save(preferenceToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        preferenceRepository.deleteById(id);
    }

    @Override
    public List<PreferenceDto> findAllDto() {
        return preferenceMapper.toListDto(findAll());
    }

    @Override
    public PreferenceDto findDtoById(int id) {
        return preferenceMapper.toDto(findById(id));
    }

    @Override
    @Transactional
    public Preference saveDto(PreferenceDto dto) {
        return save(preferenceMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public Preference updateDto(PreferenceDto dto, int id) {
        return update(preferenceMapper.toEntity(dto), id);
    }
}
