package com.example.datingApp.dtos;

import com.example.datingApp.models.Gender;

public record PreferenceDto(int id,
                            UserDto userDto,
                            Gender gender,
                            CountryDto countryDto,
                            int minAge,
                            int maxAge) {
}
