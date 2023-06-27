package com.example.datingApp.services.crud;

import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.models.ZodiacSign;
import com.example.datingApp.repositories.ZodiacSignRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ZodiacSignService implements CrudService<ZodiacSign> {

    private final ZodiacSignRepository zodiacSignRepository;

    @Override
    public List<ZodiacSign> findAll() {
        return zodiacSignRepository.findAll();
    }

    @Override
    public ZodiacSign findById(int id) {
        return zodiacSignRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public ZodiacSign save(ZodiacSign entity) {
        return zodiacSignRepository.save(entity);
    }

    @Override
    @Transactional
    public ZodiacSign update(ZodiacSign entity, int id) {
        var zodiacSignToUpdate = findById(id);
        zodiacSignToUpdate.setName(entity.getName());
        return zodiacSignRepository.save(zodiacSignToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        zodiacSignRepository.deleteById(id);
    }
}
