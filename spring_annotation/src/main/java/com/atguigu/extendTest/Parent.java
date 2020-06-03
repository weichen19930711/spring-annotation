package com.atguigu.extendTest;

public class Parent {
  protected String name;//不同包子类访问
  String sex;//同包才能访问
  /*
  super是调用父类构造方法的关键字，你不写默认也会调用的，默认就是调用父类的无参构造方法（如果父类有构造方法，并且没有写无参数构造方法的时候，
  子类必须要写super，不然编译报错）。
  为什么java中首先要调用父类的构造方法（不写super默认调用父类无参构造方法）。有些私有属性子类并不能直接访问，这时候如果不调用父类的构造方法初始化，
  那这些属性永远都是一些java初始化的默认值，所以java默认就会调用super()。
  * */
  private String _hidden;// 本内访问

  public Parent() {
    this.name = "unknown name";
  }

  public Parent(String name) {
    this.name = name;
    this._hidden = "hidden";
  }

  public String getHidden() {
    return this._hidden;
  }

}
