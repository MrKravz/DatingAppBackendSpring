package com.example.datingApp.services.crud;

import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.models.City;
import com.example.datingApp.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class CityService implements CrudService<City> {
    private final CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(int id) {
        return cityRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public City save(City entity) {
        return cityRepository.save(entity);
    }

    @Override
    @Transactional
    public City update(City entity, int id) {
        var cityToUpdate = findById(id);
        cityToUpdate.setName(entity.getName());
        return cityRepository.save(cityToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        cityRepository.deleteById(id);
    }
}
