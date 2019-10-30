package com.atguigu.test;

import com.atguigu.bean.Person;
import org.junit.Test;

public class ObjectParamsTest {

  @Test
  public void basicPassParams() {
    int num = 10;
    System.out.println("Before change, num = " + num);
    changeNum(num);
    System.out.println("After change, num = " + num);
  }

  public static void changeNum(int numVar) {
    // 基本类型作为参数传递时，是传递值的拷贝，无论你怎么改变这个拷贝，原值是不会改变的
    numVar = 100;
  }


  @Test
  public void test() {
    StringBuffer sb = new StringBuffer("Hello ");
    System.out.println("Before change, sb = " + sb);
    changeData3(sb);
    System.out.println("After changeData(n), sb = " + sb);

  }

  public static void changeData1(StringBuffer strBuf) {
    strBuf.append("World!");
  }
  public static void changeData2(StringBuffer strBuf) {
    strBuf = new StringBuffer("Hi ");
    strBuf.append("World!");
  }
  public static void changeData3(StringBuffer strBuf) {
    StringBuffer sb2 = new StringBuffer("Hi ");
    strBuf = sb2;
    strBuf.append("test");
    //sb2.append("World!");
    System.out.println(sb2);

  }
  @Test
  public void stringPassParams() {
    String str = "Hello";
    System.out.println("Before change, str = " + str);
    changeString3(str);
    System.out.println("After change, str = " + str);
  }

  public void changeString1(String str_) {
    str_ = "bb1"; // 等价于String str = new String("Hello");
  }
  public void changeString2(String str_) {
    str_ = new String("bb2");
  }
  public void changeString3(String str_) {
    str_ = str_ + " world!"; // 等价于str = new String((new StringBuffer(str)).append(" world!"));
  }

  @Test
  public void objectPassParams() {
    Person p = new Person(100);
    changeNum(p);
    System.out.println(p.getAge());
  }

  public void changeNum(Person p1) {
    // numVar = "bb";
    // p1 = new Person(10);
    p1.setAge(10);
    System.out.println(p1.getAge());
  }
}
