package com.atguigu.proxy;

public class BirdLogProxy implements FlyAble {
  private FlyAble flyable;

  public BirdLogProxy(FlyAble flyable) {
    this.flyable = flyable;
  }

  @Override
  public void fly() {
    System.out.println("Bird fly start...");
    flyable.fly();
    System.out.println("Bird fly end...");
  }
}
