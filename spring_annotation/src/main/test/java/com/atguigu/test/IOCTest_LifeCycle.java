package com.atguigu.test;

import com.atguigu.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class IOCTest_LifeCycle {

    @Test
    public void testOne(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成。。。。");
        Arrays.asList(applicationContext.getBeanDefinitionNames()).forEach(name -> System.out.println(name));
        //applicationContext.close();
    }
}
