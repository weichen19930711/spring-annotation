package com.atguigu.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Person {
    //使用@Value赋值；
    //1、基本数值
    //2、可以写SpEL； #{}
    //3、可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）
    @Value("james")
    private String name;
    @Value("#{36-2}")
    private Integer age;
    @Value("${person.nickName}")
    private String nickName;

    public Person() {

    }

    public Person(Integer age) {
      this.age = age;
    }
}
