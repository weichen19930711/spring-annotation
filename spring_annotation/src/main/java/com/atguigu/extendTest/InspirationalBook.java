package com.atguigu.extendTest;

public class InspirationalBook extends Book {
  private String name;
  public InspirationalBook() {
    // super();
    System.out.println("aaa");
  }
  public InspirationalBook(String name) {
    /*
    *   有this()时, super()在InspirationalBook()中
    * 没有this()时,super()在InspirationalBook(String name)中
    *
    * this()和super()不可能同时存在在一个构造方法中，两个方法都必须在第一行
    * */
    this();
    this.name = name;
    System.out.println(this.name);
  }
}
