package com.example.datingApp.services.dto;

import com.example.datingApp.dtos.UserDto;
import com.example.datingApp.mappers.UserMapper;
import com.example.datingApp.models.User;
import com.example.datingApp.services.crud.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserDtoService implements DtoProviderService<UserDto, User> {
    private final CrudService<User> userService;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>) userMapper.toIterableDto(userService.findAll());
    }

    @Override
    public UserDto findById(int id) {
        return userMapper.toDto(userService.findById(id));
    }

    @Override
    public User save(UserDto dto) {
        return userService.save(userMapper.toEntity(dto));
    }

    @Override
    public User update(UserDto dto, int id) {
        return userService.update(userMapper.toEntity(dto), id);
    }
}
