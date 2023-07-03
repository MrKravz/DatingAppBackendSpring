package com.example.datingApp.dtos;

import java.util.List;

public record UserDto(int id, String name, int age, String email, List<UserDto> likeProviders) {
}
