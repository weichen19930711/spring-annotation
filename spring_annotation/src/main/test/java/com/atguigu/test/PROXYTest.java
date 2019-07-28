package com.atguigu.test;

import com.atguigu.proxy.*;
import com.atguigu.proxyTest.MyInvocationHandler;
import com.atguigu.proxyTest.Proxy;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class PROXYTest {
  public static void main(String[] args) throws Exception {
    FlyAble flyAble = (FlyAble)Proxy.newProxyInstance(FlyAble.class, new MyInvocationHandler(new Bird()));
    flyAble.fly();
  }

  @Test
  public void test() {
    try {
      byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
      FileOutputStream os = new FileOutputStream("D:/$Proxy0.class");
      os.write(data);
      os.flush();
      os.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testMethod() throws Exception {
    Animal animal = new Animal("小明", 10001);
    animal.Speak();
    animal.run("10");
    Method m1 = animal.getClass().getMethod("Speak", null);
    Method m2 = animal.getClass().getMethod("run", String.class);
    System.out.println(m1);
    System.out.println(m2);
  }
  
  @Test
  public void testProxy() {
    new $Proxy0(new HomeLink());
  }

  @Test
  public void testFly() {
    Bird bird = new Bird();
    long start = System.currentTimeMillis();
    bird.fly();
    long end = System.currentTimeMillis();
    System.out.println("Fly time = " + (end - start));
  }

  @Test
  public void testSparrowFly() {
    Bird bird = new Bird();

    Sparrow sparrow = new Sparrow();
    sparrow.setBird(bird);

    Magpie magpie = new Magpie();
    magpie.setBird(sparrow);

    magpie.fly();
//    sparrow.fly();
  }
  @Test
  public void testMagpieFly() {
    Bird bird = new Bird();
    Magpie magpie = new Magpie();
    magpie.setBird(bird);
    magpie.fly();
  }

  @Test
  public void testSwallowFly() {
    Bird bird = new Bird();
    FlyAble swallow = new Swallow(bird);
    swallow.fly();
  }
  @Test
  public void testProxyFly() {
    /**
     * 日志打印结束后 然后再获取飞行时间
     */
    Bird bird = new Bird();
    BirdLogProxy p1 = new BirdLogProxy(bird);
    BirdTimeProxy p2 = new BirdTimeProxy(p1);
    p2.fly();
    /**
     * 日志打印结束前 已经获取飞行时间
     */
    /*Bird bird = new Bird();
    BirdTimeProxy p2 = new BirdTimeProxy(bird);
    BirdLogProxy p1 = new BirdLogProxy(p2);
    p1.fly();*/
  }

}
