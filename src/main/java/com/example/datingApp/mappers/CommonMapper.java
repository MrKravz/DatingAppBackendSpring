package com.example.datingApp.mappers;

import java.util.List;

public interface CommonMapper<D, E> {
    D toDto(E entity);

    E toEntity(D dto);

    List<D> toIterableDto(List<E> entityList);

    List<E> toIterableEntity(List<D> dtoList);
}
