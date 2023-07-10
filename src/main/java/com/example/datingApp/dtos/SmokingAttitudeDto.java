package com.example.datingApp.dtos;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Smoking attitude dto")
public record SmokingAttitudeDto(int id, String name) {
}
