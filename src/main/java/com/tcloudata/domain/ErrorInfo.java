package com.tcloudata.domain;

import com.tcloudata.constants.ErrorType;

/**
 * @ClassName
 * @Description TODO
 * @Author LiuYang
 * @Date 2019/1/4/004 12:00
 * @Version 1.0
 **/
public class ErrorInfo<T> {
    private Integer code;
    private String message;
    private String url;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
