package com.atguigu.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Car {

    public Car(){
        System.out.println("Car...Construct...");
    }

    //Post 置后
    @PostConstruct
    public void init(){
        System.out.println("Car...PostConstruct...");
    }

    //Pre 置前
    @PreDestroy
    public void destroy(){
        System.out.println("Car...destroy...");

    }
}
