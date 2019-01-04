package com.tcloudata.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName
 * @Description TODO
 * @Author LiuYang
 * @Date 2019/1/4/004 9:56
 * @Version 1.0
 **/
@Component
public class BlogProperties {
    @Value("${com.didispace.blog.name}")
    private String name;
    @Value("${com.didispace.blog.title}")
    private String title;

    @Value("${com.didispace.blog.desc}")
    private String desc;
    @Value("${com.didispace.blog.value}")
    private String value;
    @Value("${com.didispace.blog.number}")
    private int number;
    @Value("${com.didispace.blog.bignumber}")
    private long bignumber;
    @Value("${com.didispace.blog.test1}")
    private int test1;
    @Value("${com.didispace.blog.test2}")
    private int test2;

    public String getDesc() {
        return desc;
    }

    public String getValue() {
        return value;
    }

    public int getNumber() {
        return number;
    }

    public long getBignumber() {
        return bignumber;
    }

    public int getTest1() {
        return test1;
    }

    public int getTest2() {
        return test2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
