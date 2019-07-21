package com.atguigu.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
/*
Cat...Construct...
postProcessBeforeInitialization==>cat
Cat...afterPropertiesSet...
postProcessAfterInitialization==>cat
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("Cat...Construct...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat...afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Cat...destroy...");
    }
}
