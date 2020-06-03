package com.atguigu.extendTest;

public class Child extends Parent {
  private int age;

  public Child() {
  }

  public Child(String name) {
    super(name);
  }

  public Child(String name, int age) {
    this.name = name;
    this.age = age;
  }
  public Child(String name, int age, String sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }
}
