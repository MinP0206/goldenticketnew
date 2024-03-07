package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.model.FeeDuration;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeeDurationDto {
    private List<Integer> time; // cấu hình mỗi block có bao nhiêu phút
    private List<Integer> price; // cấu hình giờ của mỗi block
    @Schema(pattern = "HH:mm")
    private String fromTime; //tổng thời gian của một fee duration thiết lâp
    @Schema(pattern = "HH:mm")
    private String toTime;
    private Integer entireFee;// tổng phí nếu chọn nguyên đêm, nguyên ngày

    public FeeDurationDto(FeeDuration feeDuration) {

        this.time = feeDuration.getTime();
        this.price = feeDuration.getPrice();
        if(feeDuration.getFromTime()!=null) this.fromTime = feeDuration.getFromTime().toString();
        if(feeDuration.getToTime()!=null) this.toTime = feeDuration.getToTime().toString();
        this.entireFee = feeDuration.getEntireFee();

    }
}
