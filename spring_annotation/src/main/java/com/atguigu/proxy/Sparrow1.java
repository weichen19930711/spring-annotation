package com.atguigu.proxy;

/**
 * 日志
 *
 * sparrow1 => sprarrow => bird 日志包含了时间，
 *
 * 如果想要 日志不包括，还需要 再创建
 *      Sparrow3 extends bird 日志
 *      Sparrow4 extends Sparrow3 时间
 * sparrow4 => sprarrow3 => bird 日志不包含时间，
 */
public class Sparrow1 extends Sparrow {
  @Override
  public void fly() {
    System.out.println("Bird fly start...");
    super.fly();
    System.out.println("Bird fly end...");
  }
}
