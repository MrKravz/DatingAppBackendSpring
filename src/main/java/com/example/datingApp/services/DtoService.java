package com.example.datingApp.services;

import java.util.List;

public interface DtoService<D, E> {
    List<D> findAllDto();

    D findDtoById(int id);

    E saveDto(D dto);

    E updateDto(D dto, int id);
}
