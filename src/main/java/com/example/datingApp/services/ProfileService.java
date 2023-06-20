package com.example.datingApp.services;

import com.example.datingApp.models.Profile;
import com.example.datingApp.repositories.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ProfileService implements CrudService<Profile>{

    private final ProfileRepository profileRepository;

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile findById(int id) {
        return profileRepository.findById(id).orElseThrow(RuntimeException::new); //TODO Implement ex
    }

    @Override
    @Transactional
    public Profile save(Profile entity) {
        return profileRepository.save(entity);
    }

    @Override
    @Transactional
    public Profile update(Profile entity, int id) {
        var profileToUpdate = findById(id);
        // TODO write fields to change
        return profileRepository.save(profileToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        profileRepository.deleteById(id);
    }
}
