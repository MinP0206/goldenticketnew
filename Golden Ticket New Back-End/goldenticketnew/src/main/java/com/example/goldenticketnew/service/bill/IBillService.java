package com.example.goldenticketnew.service.bill;


import com.example.goldenticketnew.dtos.BookingRequestDto;

public interface IBillService {
    void createNewBill(BookingRequestDto bookingRequestDTO) throws RuntimeException;
}
