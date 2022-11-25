package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.model.Bill;
import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.payload.UserProfile;
import com.example.goldenticketnew.utils.ModelMapperUtils;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BillDto {
    private int id;
    private LocalDateTime createdTime;
    private UserProfile user;

    public BillDto(Bill bill) {
        this.id = bill.getId();
        this.createdTime = bill.getCreatedTime();
        this.user = ModelMapperUtils.mapper(bill.getUser(), UserProfile.class);
    }
}
