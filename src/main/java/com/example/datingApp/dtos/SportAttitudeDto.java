package com.example.datingApp.dtos;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Sport attitude dto")
public record SportAttitudeDto(int id, String name) {
}
