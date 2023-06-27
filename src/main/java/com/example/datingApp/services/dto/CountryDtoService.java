package com.example.datingApp.services.dto;

import com.example.datingApp.dtos.CountryDto;
import com.example.datingApp.mappers.CountryMapper;
import com.example.datingApp.models.Country;
import com.example.datingApp.services.crud.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryDtoService implements DtoProviderService<CountryDto, Country> {

    private final CountryService countryService;

    private final CountryMapper countryMapper;

    @Override
    public List<CountryDto> findAll() {
        return (List<CountryDto>) countryMapper.toIterableDto(countryService.findAll());
    }

    @Override
    public CountryDto findById(int id) {
        return countryMapper.toDto(countryService.findById(id));
    }

    @Override
    public Country save(CountryDto dto) {
        return countryService.save(countryMapper.toEntity(dto));
    }

    @Override
    public Country update(CountryDto dto, int id) {
        return countryService.update(countryMapper.toEntity(dto), id);
    }
}
