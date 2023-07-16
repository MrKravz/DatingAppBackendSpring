package com.example.datingApp.dtos;

import io.swagger.annotations.ApiModel;

import java.util.List;
@ApiModel(value = "User dto")
public record UserDto(int id,
                      String name,
                      int age,
                      String email,
                      List<UserDto> likeProviders) {
}
