package com.atguigu.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TestConfig {

  @Bean
  public ListHolder ListHolder() {
    ListHolder listHolder = new ListHolder();
    return listHolder;
  }

  @Bean
  public List<String> list() {
    ArrayList<String> strs = new ArrayList<>();
    strs.add("foo");
    strs.add("bar");
    return strs;
  }

  @Bean
  public IgnoreInterface ignoreInterface() {
    IgnoreInterface ignoreInterface = new IgnoreInterfaceImpl();
    return ignoreInterface;
  }

  @Bean
  public TestIgnore testIgnore() {
    TestIgnore testIgnore = new TestIgnore();
    return testIgnore;
  }
}
