package com.atguigu;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args){
        /*
        从类路径 获取IOC容器
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
        System.out.println(classPathXmlApplicationContext.getBean("person"));*/

        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println(annotationConfigApplicationContext.getBean("person"));

        String[] namesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }
    }

}
