package com.doctoranywhere.takehomeassignment.util;
public enum ResponseCode {
    OK(200,"successful"),
    NOT_FOUND(404,"Not found"),
    RESOURCE_EXIST(409,"Id already exists");

    private int code;
    private String message;
    ResponseCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage(){
        return message;
    }

}
