package com.atguigu.proxy;

public class Master implements Person {
  @Override
  public void searchHouse() {
    System.out.println("我是主人，我要找房子，一室一厅!");
  }
}
