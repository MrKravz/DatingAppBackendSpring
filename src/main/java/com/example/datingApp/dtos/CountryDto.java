package com.example.datingApp.dtos;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Country dto")
public record CountryDto(int id, String name) {
}
