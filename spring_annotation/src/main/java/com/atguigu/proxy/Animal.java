package com.atguigu.proxy;

import lombok.Data;

@Data
public class Animal {
  private String name;
  private Integer ID;
  public String speed;

  public Animal(String name, Integer ID){
    this.name = name;
    this.ID = ID;
  }
  public void Speak(){
    System.out.println("Hello! "+"My name is " + name);
  }
  public void run(String speed){
    System.out.println("I can run " + speed +" KM!!!");
  }
}
