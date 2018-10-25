package com.my.accountbook.common.pojo;

public class Result<T> {
    private int code;

    private String msg;

    private T data;

    private Result(Builder builder) {
        setCode(builder.code);
        setMsg(builder.msg);
        setData((T) builder.data);
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":")
                .append(code);
        sb.append(",\"msg\":\"")
                .append(msg).append('\"');
        sb.append(",\"data\":")
                .append(data);
        sb.append('}');
        return sb.toString();
    }

    public static final class Builder<T> {
        private int code;
        private String msg;
        private T data;

        public Builder() {
        }

        public Builder code(int val) {
            code = val;
            return this;
        }

        public Builder msg(String val) {
            msg = val;
            return this;
        }

        public Builder data(T val) {
            data = val;
            return this;
        }

        public Result build() {
            return new Result(this);
        }
    }
}
