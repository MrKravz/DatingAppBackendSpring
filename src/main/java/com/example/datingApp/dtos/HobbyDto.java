package com.example.datingApp.dtos;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Hobby dto")
public record HobbyDto(int id, String name) {
}
