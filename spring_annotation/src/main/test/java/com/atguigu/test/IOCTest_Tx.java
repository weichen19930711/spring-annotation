package com.atguigu.test;


import com.atguigu.tx.TxConfig;
import com.atguigu.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Tx {

    @Test
    public void testTx() {
        // 可以分两步，第一步是创建代理对象
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        // 第二步时执行代理对象的方法
        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
        userService.insertUser();
    }
}
