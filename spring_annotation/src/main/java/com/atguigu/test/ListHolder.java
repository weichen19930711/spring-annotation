package com.atguigu.test;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListHolder {

  @Autowired
  private List<String> list;

}
