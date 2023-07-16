package com.example.datingApp.dtos;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Pet attitude dto")
public record PetAttitudeDto(int id, String name) {
}
