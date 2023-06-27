package com.example.datingApp.mappers;

public interface CommonMapper<D, E> {
    D toDto(E entity);

    E toEntity(D dto);

    Iterable<D> toIterableDto(Iterable<E> entityList);

    Iterable<E> toIterableEntity(Iterable<D> dtoList);
}
