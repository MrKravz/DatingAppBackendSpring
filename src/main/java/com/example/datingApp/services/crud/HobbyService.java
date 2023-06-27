package com.example.datingApp.services.crud;

import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.models.Hobby;
import com.example.datingApp.repositories.HobbyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class HobbyService implements CrudService<Hobby> {

    private final HobbyRepository hobbyRepository;

    @Override
    public List<Hobby> findAll() {
        return hobbyRepository.findAll();
    }

    @Override
    public Hobby findById(int id) {
        return hobbyRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public Hobby save(Hobby entity) {
        return hobbyRepository.save(entity);
    }

    @Override
    @Transactional
    public Hobby update(Hobby entity, int id) {
        var hobbyToUpdate = findById(id);
        hobbyToUpdate.setName(entity.getName());
        return hobbyRepository.save(hobbyToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        hobbyRepository.deleteById(id);
    }
}
