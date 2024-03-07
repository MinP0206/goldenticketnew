package com.example.goldenticketnew.repository;

import com.example.goldenticketnew.model.Fee;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface FeeRepository extends JpaRepository<Fee, Long> {
    Fee findFirstById(Long id);
}
