package com.atguigu.config;

import com.atguigu.bean.Person;
import com.atguigu.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

//配置类==配置文件
@Configuration  //告诉Spring这是一个配置类
@ComponentScan(
    value = "com.atguigu", //扫描 该包下的所有 包含 @Controller @Service @Repository @Component的类
    //指定扫描的时候按照什么规则排除那些组件
    /*excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Repository.class})
    },*/
    //指定扫描的时候只需要包含那些组件
    useDefaultFilters = false,
    includeFilters = {
        /*@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Repository.class}),//默认按照注解 过滤
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}), //按照给定的类型 过滤
        @ComponentScan.Filter(type = FilterType.ASPECTJ), //按照ASPECTJ表达式 过滤
        @ComponentScan.Filter(type = FilterType.REGEX), //按照正则表达式 过滤*/
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class}) //按照自定义TypeFilter 过滤
    }
)
public class MainConfig {

    //给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
    @Bean("person")
    public Person person0(){
        Person person = new Person();
        person.setAge(11);
        person.setName("Ls");
        return person;
    }
}
