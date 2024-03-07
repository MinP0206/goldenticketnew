package com.example.goldenticketnew.repository;

import com.example.goldenticketnew.model.Fee;
import com.example.goldenticketnew.model.FeeDuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FeeDurationRepository extends JpaRepository<FeeDuration, Long> {

    List<FeeDuration> getAllByFeeId(Long id);
}
