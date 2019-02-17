package com.atguigu.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是否Windows系统
public class WindowsCondition implements Condition {

    /**
     *
     * @param conditionContext 判断条件 能使用的上下文（环境）
     * @param annotatedTypeMetadata 注释信息
     * @return
     */

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();//能获取到ioc使用的beanfactory
        ClassLoader classLoader = conditionContext.getClassLoader();//类加载器
        Environment environment = conditionContext.getEnvironment();//虚拟机运行环境
        BeanDefinitionRegistry registry = conditionContext.getRegistry();//获取到bean定义的注册类

        String osName = environment.getProperty("os.name");
        if(osName.contains("Windows")) return true;
        return false;
    }
}
