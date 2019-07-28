package com.atguigu.proxy;

import lombok.Data;
import lombok.Getter;

/**
 * 时间
 */
@Data
public class Sparrow extends Bird {
  private Bird bird;

  @Override
  public void fly() {
    long start = System.currentTimeMillis();
    this.bird.fly();
    long end = System.currentTimeMillis();
    System.out.println("Fly time = " + (end - start));
  }
}
