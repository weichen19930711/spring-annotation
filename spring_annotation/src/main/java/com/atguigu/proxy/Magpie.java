package com.atguigu.proxy;

import lombok.Data;

/**
 * 日志
 */
@Data
public class Magpie extends Bird {
  private Bird bird;

  @Override
  public void fly() {
    System.out.println("Bird fly start...");
    this.bird.fly();
    System.out.println("Bird fly end...");
  }
}
