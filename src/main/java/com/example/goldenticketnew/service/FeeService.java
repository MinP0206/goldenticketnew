package com.example.goldenticketnew.service;


import com.example.goldenticketnew.dtos.FeeDto;
import com.example.goldenticketnew.dtos.FeeDurationDto;
import com.example.goldenticketnew.dtos.FeeRespone;
import com.example.goldenticketnew.exception.InternalException;
import com.example.goldenticketnew.model.Fee;
import com.example.goldenticketnew.model.FeeDuration;
import com.example.goldenticketnew.model.enums.FeeMethod;
import com.example.goldenticketnew.model.enums.FeeStatus;
import com.example.goldenticketnew.payload.AddFee;
import com.example.goldenticketnew.payload.CalFee;
import com.example.goldenticketnew.repository.FeeDurationRepository;
import com.example.goldenticketnew.repository.FeeRepository;
import com.example.goldenticketnew.utils.BeanUtils;
import com.sun.xml.bind.v2.model.core.ID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.servlet.function.ServerResponse.notFound;

@Service
@RequiredArgsConstructor
public class FeeService {
    private final FeeRepository feeRepository;
    private final FeeDurationRepository feeDurationRepository;
    public FeeDto getFee(long id) {
        Fee fee = feeRepository.findFirstById(id);
        FeeDto out = new FeeDto(fee);
        return out;
    }
//    public GetFeeInfoResponse getFeeInfo(GetFeeInfoRequest request) {
//        Fee fee = feeRepository.findFirstById(request.getId());
//        if (fee == null) {
//            throw new InternalException(ResponseCode.FEE_NOT_FOUND);
//        }
//        fee.getBracketFee().sort(new ValueComparator());
//        return new GetFeeInfoResponse(true, ModelMapperUtils.mapper(fee, FeeDto.class));
//    }
    public Fee findByIdNonNull(@NonNull Long id) {
        return feeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Khong tim ra"));
    }
    public Fee addFee(AddFee a) {
        Fee fee = new Fee();
        fee.setFeeMethod(a.getFeeMethod());
        if(FeeMethod.FIXED.equals(a.getFeeMethod())){
            fee.setFixedFee(a.getFixedFee());
        }
        fee.setName(a.getName());
        fee.setCode(a.getCode());
        fee.setStatus(FeeStatus.CREATED);
        fee.setVehicleType(a.getVehicleType());
        fee = feeRepository.save(fee);
        if (a.getFeeDurations() != null && !a.getFeeDurations().isEmpty() &&  FeeMethod.DYNAMIC.equals(a.getFeeMethod())) {
            List<FeeDuration> feeDurationList = new ArrayList<>();
            for(FeeDurationDto e : a.getFeeDurations()){
                FeeDuration feeDuration = new FeeDuration();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

                feeDuration.setTime(e.getTime());
                feeDuration.setPrice(e.getPrice());
                feeDuration.setEntireFee(e.getEntireFee());
                feeDuration.setFromTime(LocalTime.parse(e.getFromTime(), formatter));
                feeDuration.setToTime(LocalTime.parse(e.getToTime(), formatter));
                feeDuration.setFeeId(fee.getId());
                feeDurationRepository.save(feeDuration);
                feeDurationList.add(feeDuration);
            }
//            fee.setFeeDurations(feeDurationList);

        }
        return fee;

    }

    public List<FeeDto> getListFee() {
        return feeRepository.findAll().stream().map(FeeDto::new).collect(Collectors.toList());

    }
    public List<Integer> getListTime(long id) {
        Fee fee = feeRepository.findById(id).orElse(null);
        if(fee == null) throw new RuntimeException("Khong tim thay fee");
        LocalTime now = LocalTime.now();
        List<FeeDuration> feeDurations =feeDurationRepository.getAllByFeeId(fee.getId());
        for(FeeDuration feeDuration : feeDurations){
            if(now.isAfter(feeDuration.getFromTime()) || now.isBefore(feeDuration.getToTime())){
                return feeDuration.getTime();
            }
        }
        throw new RuntimeException("Khong the lay block gio");
    }
    public FeeRespone calFee(CalFee calFee) {
        Fee fee = feeRepository.findById(calFee.getIdFee()).orElse(null);
        if(fee == null) throw new RuntimeException("Khong tim thay fee");
        LocalTime now = LocalTime.now();
        if(FeeMethod.FIXED.equals(fee.getFeeMethod())){
            return new FeeRespone(fee.getFixedFee());
        } else if(FeeMethod.DYNAMIC.equals(fee.getFeeMethod())){
            List<FeeDuration> feeDurations =feeDurationRepository.getAllByFeeId(fee.getId());
            for(FeeDuration feeDuration : feeDurations){
                if(now.isAfter(feeDuration.getFromTime()) || now.isBefore(feeDuration.getToTime())){
                    return new FeeRespone(calFee(feeDuration.getTime(),feeDuration.getPrice(),calFee.getPrice().intValue()));
                }
            }
        }
        throw new RuntimeException("Tinh phi khong thanh cong");
    }
    //test
    public static void main(String[] args) {
        int[] time = new int[]{60,60,60,60,60};
        int[] prices = new int[]{25000,25000,30000,30000,35000};

        FeeDuration feeDuration1 = new FeeDuration();
        feeDuration1.setEntireFee(100000);
//        feeDuration1.setTime(Arrays.stream(time).boxed().toList());
//        feeDuration1.setPrice(Arrays.stream(prices).boxed().toList());
        System.out.println("Hello world!");

        int[] a = new int[]{1,2,3,4,5,7,10};
        // 1 2 3 4 5 6 7 1
        System.out.println(calFee(Arrays.stream(time).boxed().collect(Collectors.toList()), Arrays.stream(prices).boxed().collect(Collectors.toList()),61));
    }

    public static int calFee(List<Integer> time, List<Integer> prices, int minutes) {
        int[] prefixTime = new int[prices.size()];
        int[] prefixPrice = new int[prices.size()];
        prefixTime[0] = time.get(0);
        for (int i = 1; i < time.size(); i++) {
            prefixTime[i] = prefixTime[i - 1] + time.get(i);
        }
        prefixPrice[0] = prices.get(0);
        for (int i = 1; i < prices.size(); i++) {
            prefixPrice[i] = prefixPrice[i - 1] + prices.get(i);
        }
        int temp = binarySearch(prefixTime, minutes, time.get(time.size()-1));
        if(temp > prefixPrice.length -1) {
            int a1 = prefixPrice[prefixPrice.length -1];
            int a2 = (temp - (prefixPrice.length -1));
            int a3 = prices.get(prices.size()-1);
            return a1 + a2 * a3;
        }

        return Integer.valueOf(prefixPrice[temp]);

    }

    public static int binarySearch(int[] a, int v, int endTime) {
        int i = 0;
        int j = a.length - 1;
        int mid = 0;
        while (i <= j) {
            mid = (j + i) / 2;
            if (a[mid] == v) return mid;
            if( v > a[mid]){
                i = mid + 1;
            } else {
                j = mid -1 ;
            }
        }
        if(mid == a.length -1){
            int temp = v - a[mid];
            if(temp > 0 && temp % endTime != 0){
                mid += (temp / endTime) + 1;
            } else  mid += (temp / endTime);
            return mid;
        }
        if (v > a[mid]) return mid +1;
        return mid ;
    }
}
