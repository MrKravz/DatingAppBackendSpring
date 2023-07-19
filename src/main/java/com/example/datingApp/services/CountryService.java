package com.example.datingApp.services;

import com.example.datingApp.dtos.CountryDto;
import com.example.datingApp.exceptions.CountryNotFound;
import com.example.datingApp.mappers.CountryMapper;
import com.example.datingApp.models.Country;
import com.example.datingApp.repositories.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class CountryService implements CrudService<Country>, DtoService<CountryDto, Country> {

    private final CountryRepository countryRepository;

    private final CountryMapper countryMapper;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(int id) {
        return countryRepository.findById(id).orElseThrow(CountryNotFound::new);
    }

    @Override
    @Transactional
    public Country save(Country entity) {
        return countryRepository.save(entity);
    }

    @Override
    @Transactional
    public Country update(Country entity, int id) {
        var countryToUpdate = findById(id);
        countryToUpdate.setName(entity.getName());
        return countryRepository.save(countryToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        countryRepository.deleteById(id);
    }

    @Override
    public List<CountryDto> findAllDto() {
        return countryMapper.toIterableDto(findAll());
    }

    @Override
    public CountryDto findDtoById(int id) {
        return countryMapper.toDto(findById(id));
    }

    @Override
    public Country saveDto(CountryDto dto) {
        return save(countryMapper.toEntity(dto));
    }

    @Override
    public Country updateDto(CountryDto dto, int id) {
        return update(countryMapper.toEntity(dto), id);
    }
}
