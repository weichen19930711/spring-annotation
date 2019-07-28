package com.atguigu.proxy;

import java.util.Random;

public class Bird implements FlyAble {

  @Override
  public void fly() {
    System.out.println("Bird is flying...");
    try {
//      Thread.sleep(new Random().nextInt(1000));
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
