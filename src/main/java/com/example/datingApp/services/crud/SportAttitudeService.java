package com.example.datingApp.services.crud;

import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.models.SportAttitude;
import com.example.datingApp.repositories.SportAttitudeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class SportAttitudeService implements CrudService<SportAttitude> {

    private final SportAttitudeRepository sportAttitudeRepository;

    @Override
    public List<SportAttitude> findAll() {
        return sportAttitudeRepository.findAll();
    }

    @Override
    public SportAttitude findById(int id) {
        return sportAttitudeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public SportAttitude save(SportAttitude entity) {
        return sportAttitudeRepository.save(entity);
    }

    @Override
    @Transactional
    public SportAttitude update(SportAttitude entity, int id) {
        var sportAttitudeToUpdate = findById(id);
        sportAttitudeToUpdate.setName(entity.getName());
        return sportAttitudeRepository.save(sportAttitudeToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        sportAttitudeRepository.deleteById(id);
    }
}
