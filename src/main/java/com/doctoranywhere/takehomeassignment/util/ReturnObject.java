package com.doctoranywhere.takehomeassignment.util;

import lombok.Getter;

@Getter
public class ReturnObject<T> {


    ResponseCode code = ResponseCode.OK;

    String errmsg = null;

    private T data = null;

    public ReturnObject() {
    }

    public ReturnObject(T data) {
        this();
        this.data = data;
    }

    public ReturnObject(ResponseCode code) {
        this.code = code;
    }


    public String getErrmsg() {
        if (null != this.errmsg) {
            return this.errmsg;
        }else{
            return this.code.getMessage();
        }
    }

}
