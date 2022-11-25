package com.example.goldenticketnew.enums;

public enum ResponseCode {
    SUCCESS(0, "Success"),
    FAILED(1, "Failed"),

    COMMON_ERROR(2, "Common Error"),
    INVALID_PARAM(3, "Invalid param"),

    LOGIN_FAIL(4,"Login fail"),

    //User
    USER_NOT_FOUND(101, " User not found"),

    //Movie
    MOVIE_NOT_FOUND(201, " Movie not found"),

    MOVIE_RELEASE_DATE_INVALID(202, " Release date have to after current date"),

    //Schedule
    SCHEDULE_NOT_FOUND(301, " Schedule not found"),

    //Schedule
    ARTICLE_NOT_FOUND(401, " Article not found"),

    ;
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