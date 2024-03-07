package com.example.goldenticketnew.converter;

import javax.persistence.AttributeConverter;
    import javax.persistence.Converter;
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;

@Converter
public class IntegerListConverter implements AttributeConverter<List<Integer>, String> {

    @Override
    public String convertToDatabaseColumn(List<Integer> integers) {
        if (integers == null || integers.isEmpty()) {
            return null;
        }
        return integers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(","));
    }

    @Override
    public List<Integer> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        return Arrays.stream(dbData.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
