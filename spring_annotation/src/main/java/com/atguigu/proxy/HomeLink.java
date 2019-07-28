package com.atguigu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 1. 首先获得一个 被代理对象的引用  target
 * 2. 获得该引用的接口  Person
 * 3. 生成一个类，这个类实现了我们给的代理对象所实现的接口
 * 4. 上述类编译生成了.class字节码供JVM使用
 * 5. 调用上述生成的class
 */
public class HomeLink implements InvocationHandler {

  private Person target;

  public Object getInstance(Person target) {
    this.target = target;
    Class clazz = target.getClass();
    Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    return obj;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("我是链家，我帮别人找房子..");
    method.invoke(target, args);
    System.out.println("我是链家，已经找完了..");
    return null;
  }

}
