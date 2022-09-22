package com.example.goldenmovieticketnew.repositories;

import com.example.goldenmovieticketnew.models.Role;
import com.example.goldenmovieticketnew.models.RoleName;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {

    Optional<Role> findByRole(RoleName roleName);
}
