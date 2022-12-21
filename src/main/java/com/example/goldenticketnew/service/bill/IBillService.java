package com.example.goldenticketnew.service.bill;


import com.example.goldenticketnew.dtos.BillDto;
import com.example.goldenticketnew.dtos.BookingRequestDto;

import com.example.goldenticketnew.dtos.UserReportDto;
import com.example.goldenticketnew.enums.BillStatus;
import com.example.goldenticketnew.payload.dashboard.GetDashboardTransactionRequest;
import com.example.goldenticketnew.payload.dashboard.GetDashboardTransactionResponse;

import java.util.List;

public interface IBillService {
    BillDto createNewBill(BookingRequestDto bookingRequestDTO);

    void removeBill(BookingRequestDto bookingRequestDTO);

    BillDto payBill(Integer id);

    BillDto bookingHandler(BookingRequestDto bookingRequestDTO);

    GetDashboardTransactionResponse getDashBoardTransaction(GetDashboardTransactionRequest request);

    List<UserReportDto> getUserDashBoard(BillStatus status);

    List<BillDto> getList(GetDashboardTransactionRequest request);

}
