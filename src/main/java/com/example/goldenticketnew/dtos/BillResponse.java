package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.enums.BillStatus;
import com.example.goldenticketnew.model.Bill;
import com.example.goldenticketnew.model.Ticket;
import com.example.goldenticketnew.payload.UserProfile;
import com.example.goldenticketnew.repository.TicketRepository;
import com.example.goldenticketnew.utils.BeanUtils;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class BillResponse {
    private int id;
    private LocalDateTime createdTime;
    private UserProfile user;

    private BillStatus status;

    private Double price;

    private ScheduleDto schedule;

    private List<SeatDto> seats;

    private int amountTicket;


    public BillResponse(Bill bill) {
        this.id = bill.getId();
        this.createdTime = bill.getCreatedTime();
        this.user = new UserProfile(bill.getUser());
        this.status = bill.getStatus();
        this.price = bill.getPrice();
        TicketRepository ticketRepository = BeanUtils.getBean(TicketRepository.class);
        List<Ticket> tickets = ticketRepository.findTicketsByBillId(bill.getId());
        this.amountTicket = tickets.size();
        List<SeatDto> seatDtos = new ArrayList<>();
        for(Ticket ticket : tickets){
            seatDtos.add(new SeatDto(ticket.getSeat()));
        }
        this.seats = seatDtos;
        if(!tickets.isEmpty()) this.schedule = new ScheduleDto(tickets.get(0).getSchedule());
    }
}
