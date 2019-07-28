package com.atguigu.proxy;

/**
 * 代理 FlyAble
 * 切入时间 在FlyAble 的fly方法
 *
 * 静态代理至少有以下两个局限性问题
 *  1 如果同时代理多个类，依然会导致类 无限制扩展 【BirdTimeProxy代理了FlyAble接口的实现类， 如果还想代理其他接口的实现类，则需要新的 代理类】
 *  2 如果类中有多个方法，同样的逻辑需要反复实现  【BirdTimeProxy只代理了FlyAble的fly方法，如果FlyAble有多个方法。我们需要知道其他方法的运行时间，同样的代码也至少需要重复多次 】
 */
public class BirdTimeProxy implements FlyAble{
  private FlyAble flyable;

  public BirdTimeProxy(FlyAble flyable) {
    this.flyable = flyable;
  }

  @Override
  public void fly() {
    long start = System.currentTimeMillis();
    flyable.fly();
    long end = System.currentTimeMillis();
    System.out.println("Fly time = " + (end - start));
  }
}
