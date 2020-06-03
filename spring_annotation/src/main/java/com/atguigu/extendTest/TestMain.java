package com.atguigu.extendTest;

public class TestMain {
  public static void main(String[] args) {
    // new SonOfInspirationalBook();

    System.out.println(new Child().getHidden());// null
    System.out.println(new Child("c1").getHidden());// hidden
    System.out.println(new Child("c2", 12).getHidden());/// null


  }
}
