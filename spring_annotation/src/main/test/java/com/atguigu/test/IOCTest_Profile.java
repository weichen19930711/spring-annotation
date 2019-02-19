package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfigOfProfile;
import com.atguigu.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Profile {

    //1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2、代码的方式激活某种环境；
    @Test
    public void testProfile(){
        /*AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        printAllBeanName(applicationContext);*/

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //1、创建一个applicationContext
        //2、设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("dev");
        //3、注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4、启动刷新容器
        applicationContext.refresh();
        printAllBeanName(applicationContext);
        applicationContext.close();
    }

    public void printAllBeanName(ApplicationContext applicationContext){
        for (String beanName:applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}
