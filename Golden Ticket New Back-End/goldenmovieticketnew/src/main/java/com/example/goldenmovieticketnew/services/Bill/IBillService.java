package com.example.goldenmovieticketnew.services.Bill;

import com.example.goldenmovieticketnew.dtos.BookingRequestDto;

public interface IBillService {
   void createNewBill(BookingRequestDto bookingRequest) throws RuntimeException;
}
