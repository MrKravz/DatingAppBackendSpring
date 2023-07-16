package com.example.datingApp.dtos;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Zodiac sign dto")
public record ZodiacSignDto(int id, String name) {
}
