package com.atguigu.ext;

import com.atguigu.bean.Blue;
import com.atguigu.utils.CommonUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
  public MyBeanDefinitionRegistryPostProcessor() {
    System.out.println(".");
  }
  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    System.out.println("postProcessBeanFactory：" + beanFactory.getBeanDefinitionCount());
    Arrays.asList(beanFactory.getBeanDefinitionNames()).forEach(name -> System.out.println(name));
    CommonUtils.print();
  }

  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    System.out.println("postProcessBeanDefinitionRegistry：" + registry.getBeanDefinitionCount());
    Arrays.asList(registry.getBeanDefinitionNames()).forEach(name -> System.out.println(name));
    // AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();
    // registry.registerBeanDefinition("blue_1", beanDefinition);
    CommonUtils.print();
  }
}
