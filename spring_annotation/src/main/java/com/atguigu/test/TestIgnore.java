package com.atguigu.test;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Data
public class TestIgnore {

  @Autowired
  public IgnoreInterface ignoreInterface;

  public TestIgnore() {
    System.out.println("TestIgnore ==>" + this.ignoreInterface);
  }
}
