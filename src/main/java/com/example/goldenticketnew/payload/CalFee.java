package com.example.goldenticketnew.payload;

import com.example.goldenticketnew.dtos.FeeDurationDto;
import com.example.goldenticketnew.model.enums.FeeMethod;
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
public class CalFee {

    private Long idFee;
    private Long price;
}
