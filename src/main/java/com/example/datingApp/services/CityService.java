package com.example.datingApp.services;

import com.example.datingApp.dtos.CityDto;
import com.example.datingApp.mappers.CityMapper;
import com.example.datingApp.models.City;
import com.example.datingApp.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class CityService implements CrudService<City>, DtoService<CityDto, City> {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(int id) {
        return cityRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public City save(City entity) {
        return cityRepository.save(entity);
    }

    @Override
    @Transactional
    public City update(City entity, int id) {
        var cityToUpdate = findById(id);
        cityToUpdate.setName(entity.getName());
        return cityRepository.save(cityToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        cityRepository.deleteById(id);
    }

    @Override
    public List<CityDto> findAllDto() {
        return cityMapper.toIterableDto(findAll());
    }

    @Override
    public CityDto findDtoById(int id) {
        return cityMapper.toDto(findById(id));
    }

    @Override
    public City saveDto(CityDto dto) {
        return save(cityMapper.toEntity(dto));
    }

    @Override
    public City updateDto(CityDto dto, int id) {
        return update(cityMapper.toEntity(dto), id);
    }
}
