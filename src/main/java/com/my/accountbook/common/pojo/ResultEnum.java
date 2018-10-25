package com.my.accountbook.common.pojo;

public enum ResultEnum {
    SUCCESS(0, "SUCCESS"),

    FAIL(1, "FAIL");

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
