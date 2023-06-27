package com.example.datingApp.services.dto;

import com.example.datingApp.dtos.CityDto;
import com.example.datingApp.models.City;

import java.util.List;

public interface DtoProviderService<D, E> {
    public List<D> findAll();

    public D findById(int id);

    public E save(D dto);

    public E update(D dto, int id);
}
