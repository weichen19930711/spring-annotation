package com.atguigu.config;

import com.atguigu.bean.Blue;
import com.atguigu.bean.Book;
import com.atguigu.bean.ColorFactoryBean;
import com.atguigu.bean.Person;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.MyImportBeanDefinitionRegistrar;
import com.atguigu.condition.MyImportSelector;
import com.atguigu.condition.WindowsCondition;
import org.springframework.context.annotation.*;
//类中组件统一设置，满足当前条件，这个类中配置的 所有bean注册才能生效
@Conditional(WindowsCondition.class)
@Import({Book.class, Blue.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@Configuration
public class MainConfigTwo {

    /*
        @Scope value 值有4种
            singleton 单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取就是直接从容器（map.get()）中拿；
            prototype 多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。每次获取的时候才会调用方法创建对象；
            request 同一次请求创建一个实例  很少用
            session 同一次会话创建一个实例  很少用

        @Lazy 懒加载：只针对单实例
	   		单实例bean：默认在容器启动的时候创建对象；
	   		懒加载：容器启动不创建对象。第一次从容器中使用(获取)Bean创建对象，并初始化；

	   	@Conditional 按照一定的条件进行判断，满足条件给容器中注册bean
	   	    如果系统是windows，给容器中注册("bill")
            如果是linux系统，  给容器中注册("linus")
     */
    @Scope("singleton")
    @Lazy
    @Bean("person")
    public Person person(){
        //System.out.println("给容器中添加Person....");
        Person person = new Person();
        person.setAge(23);
        person.setName("ZS");
        return person;
    }

    @Bean("bill")
    public Person personTwo(){
        Person person = new Person();
        person.setAge(62);
        person.setName("bill gates");
        return person;
    }

    @Conditional(LinuxCondition.class) //当前的bean 按照此条件判断
    @Bean("linux")
    public Person personThree(){
        Person person = new Person();
        person.setAge(48);
        person.setName("linus");
        return person;
    }

    /**
     * 给容器中注册组件；
     * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[局限于自己写的类]
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     * 		1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id 默认是全类名 [com.atguigu.bean.Book]
     * 		2）、ImportSelector:返回需要导入的组件的全类名数组
     * 		3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * 4）、使用Spring提供的 FactoryBean（工厂Bean）;
     * 		1）、默认获取到的是工厂bean调用getObject创建的对象
     * 		2）、要获取工厂Bean本身，我们需要给id前面加一个& 【&colorFactoryBean】
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
