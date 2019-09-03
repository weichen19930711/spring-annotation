package com.atguigu.config;

import com.atguigu.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.*;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * Profile：
 * Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能；
 * <p>
 * 开发环境、测试环境、生产环境；
 * 数据源：(/A)(/B)(/C)；
 *
 * @Profile： 指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 * <p>
 * 1）、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
 * 2）、写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3）、没有标注环境标识的bean在，任何环境下都是加载的；
 */
//@Profile("default")
@PropertySource("classpath:/dbconfig.properties")
@Configuration
@ComponentScan("com.atguigu.service")
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

  @Value("${jdbc.username}")
  private String username;

  @Value("${jdbc.url}")
  private String url;

  private String driverClass;

  @Bean
  public Yellow yellow() {
    Yellow yellow = new Yellow();
    return yellow;
  }

  @Override
  public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
    this.driverClass = stringValueResolver.resolveStringValue("${jdbc.driverClass}");
  }

  @Profile("dev")
  @Bean("devDataSource")
  public DataSource devDataSource(@Value("${jdbc.password}") String password) throws Exception {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setUser(this.username);
    dataSource.setPassword(password);
    dataSource.setJdbcUrl(url + "/dev");
    dataSource.setDriverClass(this.driverClass);
    return dataSource;
  }

  @Profile("test")
  @Bean
  public DataSource tesDataSource(@Value("${jdbc.password}") String password) throws Exception {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setUser(this.username);
    dataSource.setPassword(password);
    dataSource.setJdbcUrl(url + "/test");
    dataSource.setDriverClass(this.driverClass);
    return dataSource;
  }

  @Profile("prod")
  @Bean
  public DataSource prodDataSource(@Value("${jdbc.password}") String password) throws Exception {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setUser(this.username);
    dataSource.setPassword(password);
    dataSource.setJdbcUrl(url + "/test");
    dataSource.setDriverClass(this.driverClass);
    return dataSource;
  }

}
