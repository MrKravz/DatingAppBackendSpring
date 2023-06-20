package com.example.datingApp.repositories;

import com.example.datingApp.models.Role;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends ListCrudRepository<Role, Integer> {
}
