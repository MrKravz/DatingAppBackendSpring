package com.example.datingApp.dtos;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Goal dto")
public record GoalDto(int id, String name) {
}
