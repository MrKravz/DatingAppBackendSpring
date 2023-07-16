package com.example.datingApp.dtos;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "City dto")
public record CityDto(int id, CountryDto countryDto, String name) {
}
