package com.mrkid.web;

/**
 * User: xudong
 * Date: 12/2/14
 * Time: 3:41 PM
 */
public class RestResponse {
    private int code;

    private Object obj;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
