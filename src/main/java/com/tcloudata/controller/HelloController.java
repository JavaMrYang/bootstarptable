package com.tcloudata.controller;

import com.tcloudata.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName
 * @Description TODO
 * @Author LiuYang
 * @Date 2019/1/4/004 11:45
 * @Version 1.0
 **/
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("error");
    }

    @RequestMapping("/json")
    public String getJson() throws MyException {
        throw new MyException("error 2");
    }
}
