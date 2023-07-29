package com.example.datingApp.services;

import com.example.datingApp.dtos.UserDto;
import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.mappers.UserMapper;
import com.example.datingApp.models.User;
import com.example.datingApp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserService implements CrudService<User>, DtoService<UserDto, User> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    @Transactional
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    @Transactional
    public User update(User entity, int id) {
        var userToUpdate = findById(id);
        userToUpdate.setName(entity.getName());
        userToUpdate.setAge(entity.getAge());
        userToUpdate.setEmail(entity.getEmail());
        userToUpdate.setPassword(entity.getPassword());
        return userRepository.save(userToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> findAllDto() {
        return userMapper.toListDto(findAll());
    }

    @Override
    public UserDto findDtoById(int id) {
        return userMapper.toDto(findById(id));
    }

    @Override
    public User saveDto(UserDto dto) {
        return save(userMapper.toEntity(dto));
    }

    @Override
    public User updateDto(UserDto dto, int id) {
        return update(userMapper.toEntity(dto), id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
