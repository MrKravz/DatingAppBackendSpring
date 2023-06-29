package com.example.datingApp.dtos;

import java.util.List;

public record UserDto(String name, int age, String email, List<UserDto> likeProviders) {
}
