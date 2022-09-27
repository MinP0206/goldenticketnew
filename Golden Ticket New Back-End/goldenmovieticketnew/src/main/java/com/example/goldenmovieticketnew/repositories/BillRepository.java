package com.example.goldenmovieticketnew.repositories;


import com.example.goldenmovieticketnew.models.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillRepository  extends MongoRepository<Bill, String> {
}
