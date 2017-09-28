package com.guithub.helpers.ajax;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nick on 04.06.17.
 */

public class APIResponseObject<T> extends APIResponse {
    private int code;
    private APIStatusCodes status;
    private String message;
    private T data;


    private APIResponseObject(HttpServletResponse response, APIStatusCodes code) {
        super(response,code.code());
        this.status = code;
        this.message = code.getReason();
        this.code = code.code();
    }

    private APIResponseObject(HttpServletResponse response, APIStatusCodes code, String message) {
        super(response,code.code());
        this.status = code;
        this.message = code.getReason() + ": " + message;
        this.code = code.code();
    }

    private APIResponseObject(HttpServletResponse response, T data, APIStatusCodes code, String message){
        super(response,code.code());
        this.status = code;
        this.message = code.getReason()+": "+ message;
        this.data = data;
        this.code = code.code();
    }

    public static <T> APIResponseObject<T> build(HttpServletResponse response, APIStatusCodes code){
        return new APIResponseObject<>(response,code);
    }

    public static <T> APIResponseObject<T> build(HttpServletResponse response, APIStatusCodes code, String message){
        return new APIResponseObject<>(response,code,message);
    }

    public static <T> APIResponseObject<T> build(HttpServletResponse response, T data, APIStatusCodes code, String
            message){
        return new APIResponseObject<>(response,data,code,message);
    }

    public int getCode() {
        return this.code;// = this.status.code();
    }

    public void setCode(int code) {
        this.code = code;
    }

    public APIStatusCodes getStatus() {
            return this.status;
    }
    public void setStatus(APIStatusCodes status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
