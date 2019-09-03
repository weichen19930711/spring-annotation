package com.atguigu.test;

import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {

    @Test
    public void testAutowired(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        //printAllBeanName(applicationContext);

        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println("通过Autowired找到的bookDao:"+bookService);

        /*BookDao bookDao = applicationContext.getBean(BookDao.class);
        System.out.println(bookDao);*/

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println("boss:" + boss);

        Color color = applicationContext.getBean(Color.class);
        System.out.println("color:" + color);

        Car car = applicationContext.getBean(Car.class);
        System.out.println("car:" + car);

        printAllBeanName(applicationContext);
        applicationContext.close();
    }

    public void printAllBeanName(ApplicationContext applicationContext){
        for (String beanName:applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}
