package com.atguigu.proxy;

public class Swallow implements FlyAble {
  private Bird bird;

  public Swallow(Bird bird) {
    this.bird = bird;
  }

  @Override
  public void fly() {
    long start = System.currentTimeMillis();
    bird.fly();
    long end = System.currentTimeMillis();
    System.out.println("Fly time = " + (end - start));
  }
}
