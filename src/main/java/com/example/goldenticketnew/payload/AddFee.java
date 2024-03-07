package com.example.goldenticketnew.payload;

import com.example.goldenticketnew.dtos.FeeDurationDto;
import com.example.goldenticketnew.model.FeeDuration;
import com.example.goldenticketnew.model.enums.FeeMethod;
import com.example.goldenticketnew.model.enums.FeeStatus;
import com.example.goldenticketnew.model.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddFee {

    private String name;
    private String code;
    private FeeMethod feeMethod;  // fixed fee, dynamic fee
    private Integer fixedFee; // if fixed fee method => fee = fixedFee;
    private List<FeeDurationDto> feeDurations; //from time to time
    private VehicleType vehicleType; //9 seat, ...
}
