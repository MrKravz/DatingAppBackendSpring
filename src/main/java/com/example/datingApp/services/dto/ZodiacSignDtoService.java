package com.example.datingApp.services.dto;

import com.example.datingApp.dtos.ZodiacSignDto;
import com.example.datingApp.mappers.ZodiacSignMapper;
import com.example.datingApp.models.ZodiacSign;
import com.example.datingApp.services.crud.ZodiacSignService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ZodiacSignDtoService implements DtoProviderService<ZodiacSignDto, ZodiacSign> {
    private final ZodiacSignService zodiacSignService;
    private final ZodiacSignMapper zodiacSignMapper;

    @Override
    public List<ZodiacSignDto> findAll() {
        return (List<ZodiacSignDto>) zodiacSignMapper.toIterableDto(zodiacSignService.findAll());
    }

    @Override
    public ZodiacSignDto findById(int id) {
        return zodiacSignMapper.toDto(zodiacSignService.findById(id));
    }

    @Override
    public ZodiacSign save(ZodiacSignDto dto) {
        return zodiacSignService.save(zodiacSignMapper.toEntity(dto));
    }

    @Override
    public ZodiacSign update(ZodiacSignDto dto, int id) {
        return zodiacSignService.update(zodiacSignMapper.toEntity(dto), id);
    }
}
