package com.example.datingApp.repositories;

import com.example.datingApp.models.ZodiacSign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZodiacSignRepository extends JpaRepository<ZodiacSign, Integer> {
}
