package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_PropertyValue {

    @Test
    public void testValueAnnotation(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);

        printAllBeanName(applicationContext);

        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        applicationContext.close();
    }

    public void printAllBeanName(ApplicationContext applicationContext){
        for (String beanName:applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}
