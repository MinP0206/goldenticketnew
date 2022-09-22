package com.example.goldenticketnew.repository;


import com.example.goldenticketnew.model.Role;
import com.example.goldenticketnew.model.RoleName;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface RoleRepository extends MongoRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
