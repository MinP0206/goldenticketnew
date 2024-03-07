package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.model.Fee;
import com.example.goldenticketnew.model.FeeDuration;
import com.example.goldenticketnew.model.enums.FeeMethod;
import com.example.goldenticketnew.model.enums.FeeStatus;
import com.example.goldenticketnew.model.enums.VehicleType;
import com.example.goldenticketnew.repository.FeeDurationRepository;
import com.example.goldenticketnew.utils.BeanUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeeDto {
    private Long id;

    private String name;
    private String code;
    private FeeStatus status; //status
    private FeeMethod feeMethod;  // fixed fee, dynamic fee
    private Integer fixedFee; // if fixed fee method => fee = fixedFee;

    private List<FeeDurationDto> feeDurations; //from time to time
    private VehicleType vehicleType; //9 seat, ...

    public FeeDto(Fee fee) {
        id = fee.getId();
        name = fee.getName();
        code = fee.getCode();
        status = fee.getStatus();
        feeMethod = fee.getFeeMethod();
        fixedFee = fee.getFixedFee();
//        List<FeeDuration> feeDurationList = fee.getFeeDurations();
        FeeDurationRepository feeDurationRepository = BeanUtils.getBean(FeeDurationRepository.class);
        feeDurations =feeDurationRepository.getAllByFeeId(fee.getId()).stream().map(FeeDurationDto::new).collect(Collectors.toList());
//        feeDurations = feeDurationList.stream().map(FeeDurationDto::new).collect(Collectors.toList());
        vehicleType = fee.getVehicleType();
    }
}
