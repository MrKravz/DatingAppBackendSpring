package com.example.datingApp.services.crud;

import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.models.SmokingAttitude;
import com.example.datingApp.repositories.SmokingAttitudeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class SmokingAttitudeService implements CrudService<SmokingAttitude> {

    private final SmokingAttitudeRepository smokingAttitudeRepository;

    @Override
    public List<SmokingAttitude> findAll() {
        return smokingAttitudeRepository.findAll();
    }

    @Override
    public SmokingAttitude findById(int id) {
        return smokingAttitudeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public SmokingAttitude save(SmokingAttitude entity) {
        return smokingAttitudeRepository.save(entity);
    }

    @Override
    @Transactional
    public SmokingAttitude update(SmokingAttitude entity, int id) {
        var smokingAttitudeToUpdate = findById(id);
        smokingAttitudeToUpdate.setName(entity.getName());
        return smokingAttitudeRepository.save(smokingAttitudeToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        smokingAttitudeRepository.deleteById(id);
    }
}
