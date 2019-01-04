package com.tcloudata.exception;

/**
 * @ClassName
 * @Description  自定义异常
 * @Author LiuYang
 * @Date 2019/1/4/004 14:08
 * @Version 1.0
 **/
public class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
}
