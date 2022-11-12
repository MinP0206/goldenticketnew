package com.example.goldenticketnew.repository;


import com.example.goldenticketnew.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepository extends JpaRepository<Bill, Integer> {
}