package com.atguigu.ext;

import com.atguigu.utils.CommonUtils;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
  @Override
  public void onApplicationEvent(ApplicationEvent event) {
    System.out.println("MyApplicationListener收到事件：" + event.toString());
    CommonUtils.print();
  }
}
