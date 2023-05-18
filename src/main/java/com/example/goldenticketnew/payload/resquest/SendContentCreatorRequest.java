package com.example.goldenticketnew.payload.resquest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendContentCreatorRequest {
    private String reason;
    @NotNull
    private Long userId;
}