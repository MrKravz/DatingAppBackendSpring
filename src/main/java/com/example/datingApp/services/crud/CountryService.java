package com.example.datingApp.services.crud;

import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.models.Country;
import com.example.datingApp.repositories.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class CountryService implements CrudService<Country> {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(int id) {
        return countryRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public Country save(Country entity) {
        return countryRepository.save(entity);
    }

    @Override
    @Transactional
    public Country update(Country entity, int id) {
        var countryToUpdate = findById(id);
        countryToUpdate.setName(entity.getName());
        return countryRepository.save(countryToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        countryRepository.deleteById(id);
    }
}
