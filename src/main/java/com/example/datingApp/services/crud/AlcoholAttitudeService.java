package com.example.datingApp.services.crud;

import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.models.AlcoholAttitude;
import com.example.datingApp.repositories.AlcoholAttitudeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class AlcoholAttitudeService implements CrudService<AlcoholAttitude> {

    private final AlcoholAttitudeRepository alcoholAttitudeRepository;

    @Override
    public List<AlcoholAttitude> findAll() {
        return alcoholAttitudeRepository.findAll();
    }

    @Override
    public AlcoholAttitude findById(int id) {
        return alcoholAttitudeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public AlcoholAttitude save(AlcoholAttitude entity) {
        return alcoholAttitudeRepository.save(entity);
    }

    @Override
    @Transactional
    public AlcoholAttitude update(AlcoholAttitude entity, int id) {
        var alcoholAttitudeToUpdate = findById(id);
        alcoholAttitudeToUpdate.setName(entity.getName());
        return alcoholAttitudeRepository.save(alcoholAttitudeToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        alcoholAttitudeRepository.deleteById(id);
    }
}
