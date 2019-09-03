package com.atguigu.test;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class IgnoreInterfaceImpl implements IgnoreInterface{

  @Autowired
  private List<String> list;

  @Override
  public void setList(List<String> list) {
    System.out.println("setList ==>" +list);
    this.list = list;
  }
}
