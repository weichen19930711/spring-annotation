package com.atguigu.proxy;

public class TestSearchHouse {

  public static void main(String[] args) {
    Person person = new Master();
    Person proxyPerson = (Person) new HomeLink().getInstance(person);
    proxyPerson.searchHouse();
    /*Object instance = new HomeLink().getInstance(person);
    if (instance instanceof Person) {
      Person proxyPerson = (Person)instance;
      proxyPerson.searchHouse();
    }*/
  }
}
