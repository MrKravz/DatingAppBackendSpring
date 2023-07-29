package com.example.datingApp.mappers;

public interface RequestMappers<D, E> {
    D toDto(E entity);

    E toEntity(D dto);
}
