package com.atguigu.proxy;

import org.springframework.stereotype.Component;

@Component
public class Bird implements FlyAble {

  @Override
  public void fly() {
    System.out.println("Bird is flying...");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
