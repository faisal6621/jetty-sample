package com.faisal.dto;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

    private static final long serialVersionUID = 7194212116327866464L;

    private String greeting;
    private long time;
    private String ip;

    public ResponseDTO(String greeting, long time) {
        super();
        this.greeting = greeting;
        this.time = time;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
