package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Test_1 {

  @Test
  public void test1 () {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
    Arrays.asList(annotationConfigApplicationContext.getBeanDefinitionNames()).forEach(name -> {
      System.out.println(name);
    });

    System.out.println(annotationConfigApplicationContext.getBean(TestIgnore.class));

  }

  @Test
  public void test2 () {
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/beans.xml");
    Arrays.asList(classPathXmlApplicationContext.getBeanDefinitionNames()).forEach(item -> {
      System.out.println(item + " ==> " + classPathXmlApplicationContext.getBean(item));
    });

  }
}
