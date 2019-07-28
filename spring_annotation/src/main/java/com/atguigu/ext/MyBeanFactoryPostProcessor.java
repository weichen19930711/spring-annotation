package com.atguigu.ext;

import com.atguigu.utils.CommonUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    System.out.println("post processor bean factory");
    System.out.println("容器中bean定义信息总数" + beanFactory.getBeanDefinitionCount());
    Arrays.asList(beanFactory.getBeanDefinitionNames()).forEach(name -> System.out.println(name));
    CommonUtils.print();
  }
}
