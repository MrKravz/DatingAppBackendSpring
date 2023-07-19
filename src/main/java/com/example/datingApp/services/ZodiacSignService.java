package com.example.datingApp.services;

import com.example.datingApp.dtos.ZodiacSignDto;
import com.example.datingApp.exceptions.ZodiacSignNotFound;
import com.example.datingApp.mappers.ZodiacSignMapper;
import com.example.datingApp.models.ZodiacSign;
import com.example.datingApp.repositories.ZodiacSignRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ZodiacSignService implements CrudService<ZodiacSign>, DtoService<ZodiacSignDto, ZodiacSign> {

    private final ZodiacSignRepository zodiacSignRepository;
    private final ZodiacSignMapper zodiacSignMapper;

    @Override
    public List<ZodiacSign> findAll() {
        return zodiacSignRepository.findAll();
    }

    @Override
    public ZodiacSign findById(int id) {
        return zodiacSignRepository.findById(id).orElseThrow(ZodiacSignNotFound::new);
    }

    @Override
    @Transactional
    public ZodiacSign save(ZodiacSign entity) {
        return zodiacSignRepository.save(entity);
    }

    @Override
    @Transactional
    public ZodiacSign update(ZodiacSign entity, int id) {
        var zodiacSignToUpdate = findById(id);
        zodiacSignToUpdate.setName(entity.getName());
        return zodiacSignRepository.save(zodiacSignToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        zodiacSignRepository.deleteById(id);
    }

    @Override
    public List<ZodiacSignDto> findAllDto() {
        return zodiacSignMapper.toIterableDto(findAll());
    }

    @Override
    public ZodiacSignDto findDtoById(int id) {
        return zodiacSignMapper.toDto(findById(id));
    }

    @Override
    public ZodiacSign saveDto(ZodiacSignDto dto) {
        return save(zodiacSignMapper.toEntity(dto));
    }

    @Override
    public ZodiacSign updateDto(ZodiacSignDto dto, int id) {
        return update(zodiacSignMapper.toEntity(dto), id);
    }
}
