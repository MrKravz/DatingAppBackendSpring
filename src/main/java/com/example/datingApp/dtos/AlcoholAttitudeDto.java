package com.example.datingApp.dtos;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Alcohol attitude dto")
public record AlcoholAttitudeDto(int id, String name) {
}
