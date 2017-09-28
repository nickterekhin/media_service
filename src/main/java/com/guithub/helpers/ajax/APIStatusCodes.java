package com.guithub.helpers.ajax;

import org.springframework.http.HttpStatus;

/**
 * Created by Nick on 04.06.17.
 */
public enum APIStatusCodes{

    SUCCESS(200,"Success"),
    ERROR(500,"Error"),
    REQUEST_DATA_ERROR(510,"Request data error"),
    DB_FAIL(520,"DataBase error"),
    AUTHENTICATION_ERROR(530,"Authentication Error");


    private int code;
    private String errorMessage;

    APIStatusCodes(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }
    public static APIStatusCodes valueOf(int statusCode) {
        for (APIStatusCodes status : values()) {
            if (status.code == statusCode) {
                return status;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
    }

    public int code() {
        return code;
    }


    public String getReason() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return Integer.toString(this.code);
    }
}
