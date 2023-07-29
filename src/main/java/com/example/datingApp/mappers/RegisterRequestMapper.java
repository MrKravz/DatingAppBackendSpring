package com.example.datingApp.mappers;

import com.example.datingApp.models.User;
import com.example.datingApp.requests.RegisterRequest;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegisterRequestMapper extends RequestMappers<RegisterRequest, User> {
}
