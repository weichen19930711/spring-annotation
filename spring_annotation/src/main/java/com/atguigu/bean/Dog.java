package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

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
