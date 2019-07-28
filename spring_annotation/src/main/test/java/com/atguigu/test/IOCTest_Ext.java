package com.atguigu.test;

import com.atguigu.ext.ExtConfig;
import com.atguigu.utils.CommonUtils;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class IOCTest_Ext {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
    Arrays.asList(annotationConfigApplicationContext.getBeanNamesForType(BeanPostProcessor.class)).forEach(beanName -> System.out.println(beanName));
    CommonUtils.print();
    Arrays.asList(annotationConfigApplicationContext.getBeanNamesForType(BeanFactoryPostProcessor.class)).forEach(beanName -> System.out.println(beanName));
    CommonUtils.print();
    annotationConfigApplicationContext.publishEvent(new ApplicationEvent(new String("test")) {
      /*@Override
      public String toString() {
        System.out.println(super.toString());
        CommonUtils.print();
        return super.toString();
      }*/
    });
    annotationConfigApplicationContext.close();
  }
}
