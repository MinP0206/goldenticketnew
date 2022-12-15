package com.example.goldenticketnew.controller;


import com.example.goldenticketnew.dtos.BookingRequestDto;
import com.example.goldenticketnew.service.bill.IBillService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/bills")
@Tag(name = "Bill Controller", description = "Thao tác với hóa đơn")
public class BillController {
    @Autowired
    private IBillService billService;
    @Operation(
        summary = "Tạo hóa đơn ",
        description = "- Tạo hóa đơn"
    )
    @PostMapping("/create-new-bill")
    public ResponseEntity<String> createNewBill(@Valid @RequestBody BookingRequestDto bookingRequestDTO) {
        try {
            billService.createNewBill(bookingRequestDTO);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>("Bạn đã mua vé xem phim thành công !", HttpStatus.OK);
    }
}
