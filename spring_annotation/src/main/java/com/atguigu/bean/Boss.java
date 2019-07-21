package com.atguigu.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//默认加在ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作
@Data
@Component
public class Boss {

    private Car car;

    /*
    //构造器要用的组件，都是从容器中获取
    @Autowired
    public Boss(Car car){
        this.car = car;
        System.out.println("Boss...有参构造器");
    }*/

    // 和上面的是等价的, 如果组件只有一个有参构造器。这个有参构造器的 @Autowired可以省略
    public Boss(Car car){
        this.car = car;
        System.out.println("Boss...有参构造器");
    }


//    @Autowired
    //标注在方法，Spring容器创建当前对象，就会调用方法，完成赋值；
    //方法使用的参数，自定义类型的值从ioc容器中获取
    /*public void set(Car car){
        this.car = car;
    }*/
    // 和上面是等价的
    /*public void set(@Autowired Car car){
        this.car = car;
    }*/
}
