package com.tcloudata.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName
 * @Description TODO
 * @Author LiuYang
 * @Date 2019/1/3/003 10:56
 * @Version 1.0
 **/
@ConfigurationProperties(prefix = JedisProperties.JEDIS_SERVER)
public class JedisProperties {
    public static final String JEDIS_SERVER = "application-dev.yml";
    @Value("redis.server.host")
    private String host;
    @Value("redis.server.port")
    private int port;
    @Value("redis.server.password")
    private String password;
    @Value("redis.server.maxTotal")
    private int maxTotal;
    @Value("redis.server.maxIdle")
    private int maxIdle;
    @Value("redis.server.maxWaitMillis")
    private int maxWaitMillis;
    @Value("redis.server.timeOut")
    private int timeOut;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public static void main(String[] args) {
        JedisProperties jedisProperties=new JedisProperties();
        System.out.println(jedisProperties.host);
    }
}

