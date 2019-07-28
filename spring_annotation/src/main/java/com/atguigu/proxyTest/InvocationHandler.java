package com.atguigu.proxyTest;

import java.lang.reflect.Method;

public interface InvocationHandler {
  /**
   * @param proxy 这个参数指定动态生成的代理类，这里是TimeProxy
   * @param method 这个参数表示传入接口中的所有Method对象
   * @param args 这个参数对应当前method方法中的参数
   */
  void invoke(Object proxy, Method method, Object[] args);
}
