package com.example.goldenticketnew.enums;

public enum ResponseCode {
    SUCCESS(0, "Success"),
    FAILED(1, "Failed"),
    COMMON_ERROR(2, "Common Error"),
    INVALID_PARAM(3, "Invalid param"),;

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ResponseCode valueOf(long value) {
        for (ResponseCode responseCode : ResponseCode.values()) {
            if (responseCode.getCode() == value) {
                return responseCode;
            }
        }
        return null;
    }
}