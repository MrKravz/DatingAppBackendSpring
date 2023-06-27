package com.example.datingApp.services.crud;

import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.models.User;
import com.example.datingApp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserService implements CrudService<User> {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
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
}
