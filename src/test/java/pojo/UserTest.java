package pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void testUserDI(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-v1.1.xml");

        User user = (User) context.getBean("user");
        System.out.println(user);
    }
    //测试构造方法注入
    @Test
    public void testConstruct(){

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-v1.2.xml");

        User user = (User) context.getBean("user");
        System.out.println(user);

    }
    //测试autowire注入
    @Test
    public void testAutowire(){

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-v1.3.xml");

        User user = (User) context.getBean("user");
        System.out.println(user);

    }
    //类的注解
    @Test
    public void testAnno(){

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-v1.4.xml");

        User user = (User) context.getBean("user");
        //Dog dog = (Dog) context.getBean("dog");
        System.out.println(user);

    }
    //对象的生命周期
    @Test
    public void testInit(){

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-v1.5.xml");

        User user = (User) context.getBean("tom");
        //user.work(); //真实的任务

        //关系spring容器
        context.close();

    }
}