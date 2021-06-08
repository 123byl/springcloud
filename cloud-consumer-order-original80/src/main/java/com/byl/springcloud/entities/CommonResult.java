package com.byl.springcloud.entities;

public class CommonResult<T> {
    public Integer code;
    public String message;
    public T data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
