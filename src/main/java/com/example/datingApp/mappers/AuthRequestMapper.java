package com.example.datingApp.mappers;

import com.example.datingApp.models.User;
import com.example.datingApp.requests.AuthRequest;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthRequestMapper extends RequestMappers<AuthRequest, User> {
}
