package com.example.datingApp.services;

import com.example.datingApp.dtos.HobbyDto;
import com.example.datingApp.mappers.HobbyMapper;
import com.example.datingApp.models.Hobby;
import com.example.datingApp.repositories.HobbyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class HobbyService implements CrudService<Hobby>, DtoService<HobbyDto, Hobby> {

    private final HobbyRepository hobbyRepository;

    private final HobbyMapper hobbyMapper;

    @Override
    public List<Hobby> findAll() {
        return hobbyRepository.findAll();
    }

    @Override
    public Hobby findById(int id) {
        return hobbyRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public Hobby save(Hobby entity) {
        return hobbyRepository.save(entity);
    }

    @Override
    @Transactional
    public Hobby update(Hobby entity, int id) {
        var hobbyToUpdate = findById(id);
        hobbyToUpdate.setName(entity.getName());
        return hobbyRepository.save(hobbyToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        hobbyRepository.deleteById(id);
    }

    @Override
    public List<HobbyDto> findAllDto() {
        return hobbyMapper.toIterableDto(findAll());
    }

    @Override
    public HobbyDto findDtoById(int id) {
        return hobbyMapper.toDto(findById(id));
    }

    @Override
    public Hobby saveDto(HobbyDto dto) {
        return save(hobbyMapper.toEntity(dto));
    }

    @Override
    public Hobby updateDto(HobbyDto dto, int id) {
        return update(hobbyMapper.toEntity(dto), id);
    }
}
