package com.example.datingApp.services;

import com.example.datingApp.dtos.ProfileDto;
import com.example.datingApp.exceptions.ProfileNotFoundException;
import com.example.datingApp.mappers.ProfileMapper;
import com.example.datingApp.models.Profile;
import com.example.datingApp.repositories.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ProfileService implements CrudService<Profile>, DtoService<ProfileDto, Profile>, FindByPreferenceService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile findById(int id) {
        return profileRepository.findById(id).orElseThrow(ProfileNotFoundException::new);
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
        profileToUpdate.setHeight(entity.getHeight());
        profileToUpdate.setAbout(entity.getAbout());
        profileToUpdate.setCountry(entity.getCountry());
        profileToUpdate.setCity(entity.getCity());
        profileToUpdate.setZodiacSign(entity.getZodiacSign());
        profileToUpdate.setGoal(entity.getGoal());
        profileToUpdate.setAlcoholAttitude(entity.getAlcoholAttitude());
        profileToUpdate.setSmokingAttitude(entity.getSmokingAttitude());
        profileToUpdate.setSportAttitude(entity.getSportAttitude());
        profileToUpdate.setPetAttitude(entity.getPetAttitude());
        return profileRepository.save(profileToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        profileRepository.deleteById(id);
    }

    @Override
    public List<ProfileDto> findAllDto() {
        return profileMapper.toIterableDto(findAll());
    }

    @Override
    public ProfileDto findDtoById(int id) {
        return profileMapper.toDto(findById(id));
    }

    @Override
    @Transactional
    public Profile saveDto(ProfileDto dto) {
        return save(profileMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public Profile updateDto(ProfileDto dto, int id) {
        return update(profileMapper.toEntity(dto), id);
    }

    @Override
    public List<Profile> findByAgeGap(int minAge, int maxAge) {
        return profileRepository.findByAgeGap(minAge, maxAge);
    }
}
