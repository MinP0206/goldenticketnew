package com.example.goldenticketnew.controller;

import com.example.goldenticketnew.dtos.FeeDto;
import com.example.goldenticketnew.dtos.FeeRespone;
import com.example.goldenticketnew.model.Fee;
import com.example.goldenticketnew.payload.AddFee;
import com.example.goldenticketnew.payload.CalFee;
import com.example.goldenticketnew.payload.response.ResponseBase;
import com.example.goldenticketnew.service.FeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Profile("dev")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/fee")
@RequiredArgsConstructor
@Tag(name = "Fee Controller", description = "Thao tác với goi cuoc")
public class FeeController {
    private final FeeService feeService;


    @Operation(
        summary = "tao fee ",
        description = "- tao  fee"
    )
    @PostMapping("/create")
    public ResponseEntity<Fee> createFee(@RequestBody AddFee fee) {
        return new ResponseEntity<>(feeService.addFee(fee), HttpStatus.OK);
    }
    @Operation(
        summary = "Tinh phi ",
        description = "- Tnh phi"
    )
    @GetMapping("/")
    public ResponseEntity<ResponseBase<FeeRespone>> getFee(@ParameterObject CalFee calFee) {
        return new ResponseEntity<>(new ResponseBase<>(feeService.calFee(calFee)), HttpStatus.OK);
    }

    @Operation(
        summary = "Lấy Danh sach ",
        description = "- Lấy Danh sach"
    )
    @GetMapping("/getAll")
    public ResponseEntity<ResponseBase<List<FeeDto>>> getList() {
        return new ResponseEntity<>(new ResponseBase<>(feeService.getListFee()), HttpStatus.OK);
    }
    @Operation(
        summary = "Lấy Danh sach ",
        description = "- Lấy Danh sach"
    )
    @GetMapping("/getBlockTime/{feeId}")
    public ResponseEntity<ResponseBase<List<Integer>>> getTime(@PathVariable Long feeId) {
        return new ResponseEntity<>(new ResponseBase<>(feeService.getListTime(feeId)), HttpStatus.OK);
    }
    @Operation(
        summary = "Lấy thông tin chi tiết 1 Bill ",
        description = "- Lấy thông tin chi tiết 1 Bill"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBase<FeeDto>> getOneFee(@PathVariable Long id) {
        return new ResponseEntity<>(new ResponseBase<>(feeService.getFee(id)), HttpStatus.OK);
    }
}