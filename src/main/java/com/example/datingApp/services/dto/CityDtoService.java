package com.example.datingApp.services.dto;

import com.example.datingApp.dtos.CityDto;
import com.example.datingApp.mappers.CityMapper;
import com.example.datingApp.models.City;
import com.example.datingApp.services.crud.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityDtoService implements DtoProviderService<CityDto, City> {

    private final CrudService<City> cityService;

    private final CityMapper cityMapper;

    @Override
    public List<CityDto> findAll() {
        return (List<CityDto>) cityMapper.toIterableDto(cityService.findAll());
    }

    @Override
    public CityDto findById(int id) {
        return cityMapper.toDto(cityService.findById(id));
    }

    @Override
    public City save(CityDto dto) {
        return cityService.save(cityMapper.toEntity(dto));
    }

    @Override
    public City update(CityDto dto, int id) {
        return cityService.update(cityMapper.toEntity(dto), id);
    }
}
