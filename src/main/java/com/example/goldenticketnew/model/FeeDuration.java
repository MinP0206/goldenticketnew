package com.example.goldenticketnew.model;

import com.example.goldenticketnew.converter.IntegerListConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "fee_duration")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class FeeDuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Convert(converter = IntegerListConverter.class)
    private List<Integer> time; // cấu hình mỗi block có bao nhiêu phút

    @Convert(converter = IntegerListConverter.class)
    private List<Integer> price; // cấu hình giờ của mỗi block
    private LocalTime fromTime; //tổng thời gian của một fee duration thiết lâp
    private LocalTime toTime;
    private Integer entireFee;// tổng phí nếu chọn nguyên đêm, nguyên ngày

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "fee_id", referencedColumnName = "id")
//    private Fee fee;
    private Long feeId;
}
