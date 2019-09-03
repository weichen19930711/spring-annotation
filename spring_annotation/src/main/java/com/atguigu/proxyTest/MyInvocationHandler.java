package com.atguigu.proxyTest;

import com.atguigu.proxy.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component
public class MyInvocationHandler implements InvocationHandler {

  @Autowired
  private Bird bird;

  public MyInvocationHandler(Bird bird) {
    this.bird = bird;
  }

  @Override
  public void invoke(Object proxy, Method method, Object[] args) {
    long start = System.currentTimeMillis();

    try {
      method.invoke(bird, args);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    long end = System.currentTimeMillis();
    System.out.println("Fly time = " + (end - start));
  }
}