package com.atguigu.condition;

import com.atguigu.bean.Rainbow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata：当前配置类的注解信息
     * BeanDefinitionRegistry:BeanDefinition注册类；
     * 		把所有需要添加到容器中的bean；调用
     * 		BeanDefinitionRegistry.registerBeanDefinition 手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean b1 = beanDefinitionRegistry.containsBeanDefinition("com.atguigu.bean.Blue");
        boolean b2 = beanDefinitionRegistry.containsBeanDefinition("com.atguigu.bean.Red");

        if(b1 && b2) {
            BeanDefinition beanDefinition = new RootBeanDefinition(Rainbow.class);
            //指定bean 的名称 <bean> 的id
            beanDefinitionRegistry.registerBeanDefinition("rainbow", beanDefinition);
        }
    }
}
