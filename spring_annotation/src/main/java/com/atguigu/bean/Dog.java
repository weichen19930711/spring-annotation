package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;
/*
Dog...Construct...
当前Bean的Name:dog
解析 当前系统是 ${os.name}的结果:当前系统是 Windows 10
org.springframework.context.annotation.AnnotationConfigApplicationContext@8807e25: startup date [Sun Jul 21 14:12:00 GMT+08:00 2019]; root of context hierarchy
postProcessBeforeInitialization==>dog
Dog...init...
postProcessAfterInitialization==>dog
 */
@Component
public class Dog implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    public Dog(){
        System.out.println("Dog...Construct...");
    }

    public void init(){
        System.out.println("Dog...init...");
    }

    public void destroy(){
        System.out.println("Dog...destroy...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("当前Bean的Name:" + s);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("解析 当前系统是 ${os.name}" + "的结果:" + resolver.resolveStringValue("当前系统是 ${os.name}") );
    }
}
