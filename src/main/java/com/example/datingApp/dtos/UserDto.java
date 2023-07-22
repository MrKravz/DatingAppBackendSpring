package com.example.datingApp.dtos;

import io.swagger.annotations.ApiModel;
@ApiModel(value = "User dto")
public record UserDto(int id,
                      String name,
                      int age,
                      String email) {
}
