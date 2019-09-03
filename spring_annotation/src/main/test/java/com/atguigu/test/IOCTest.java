package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfigTwo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class IOCTest {

    @Test
    public void testOne(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void testScope(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigTwo.class);
        System.out.println("IOC容器加载完成...");

        Object person1 = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");

        System.out.println(person1 == person2);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void testCondition(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigTwo.class);

        //动态获取当前操作系统 的名称
        System.out.println(applicationContext.getEnvironment().getProperty("os.name"));

        //按照类型，获取该类型的所有bean 的名称
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name:beanNamesForType) {
            System.out.println(name);
        }

        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    @Test
    public void testImport(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigTwo.class);
        printAllBeanName(applicationContext);

        Object color1 = applicationContext.getBean("colorFactoryBean");
        System.out.println(color1.getClass());
        Object color2 = applicationContext.getBean("colorFactoryBean");
        System.out.println(color2.getClass());
        System.out.println(color1 == color2);

        Object colorFactoryBean = applicationContext.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean.getClass());
    }

    public void printAllBeanName(ApplicationContext applicationContext){
        for (String beanName:applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}

