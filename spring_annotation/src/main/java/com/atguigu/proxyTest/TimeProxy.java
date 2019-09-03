package com.atguigu.proxyTest;

import com.atguigu.proxy.FlyAble;
import java.lang.Override;
import java.lang.reflect.Method;

class TimeProxy implements FlyAble {
  private InvocationHandler handler;

  public TimeProxy(InvocationHandler handler) {
    this.handler = handler;
  }

  @Override
  public void fly() {
    try {
    	Method method = com.atguigu.proxy.FlyAble.class.getMethod("fly");
    	this.handler.invoke(this, method, null);
    } catch(Exception e) {
    	e.printStackTrace();
    }
  }
}
