package com.atguigu.ext;

import com.atguigu.utils.CommonUtils;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @EventListener(ApplicationEvent.class)
  public void test(ApplicationEvent event) {
    System.out.println("UserService收到事件：" + event.toString());
    CommonUtils.print();
  }
}
