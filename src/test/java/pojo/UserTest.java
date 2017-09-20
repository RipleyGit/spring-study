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
}