package com.example.datingApp.services.crud;

import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.models.PetAttitude;
import com.example.datingApp.repositories.PetAttitudeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class PetAttitudeService implements CrudService<PetAttitude>{

    private final PetAttitudeRepository petAttitudeRepository;

    @Override
    public List<PetAttitude> findAll() {
        return petAttitudeRepository.findAll();
    }

    @Override
    public PetAttitude findById(int id) {
        return petAttitudeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public PetAttitude save(PetAttitude entity) {
        return petAttitudeRepository.save(entity);
    }

    @Override
    @Transactional
    public PetAttitude update(PetAttitude entity, int id) {
        var petAttitudeToUpdate = findById(id);
        petAttitudeToUpdate.setName(entity.getName());
        return petAttitudeRepository.save(petAttitudeToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        petAttitudeRepository.deleteById(id);
    }
}
