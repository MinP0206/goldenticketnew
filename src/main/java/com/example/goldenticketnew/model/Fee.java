package com.example.goldenticketnew.model;

import com.example.goldenticketnew.model.enums.FeeMethod;
import com.example.goldenticketnew.model.enums.FeeStatus;
import com.example.goldenticketnew.model.enums.VehicleType;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "fee")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class Fee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private FeeStatus status; //status
    private FeeMethod feeMethod;  // fixed fee, dynamic fee
    private Integer fixedFee; // if fixed fee method => fee = fixedFee;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "fee")
//    private List<FeeDuration> feeDurations; //from time to time
    private VehicleType vehicleType; //9 seat, ...

}
