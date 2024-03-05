package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Component
@ConfigurationProperties(prefix = "custom")
public class CustomProps {

    private String hello = "";

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
