package factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

import static org.junit.Assert.*;

public class SpringFactoryTest {
    //测试spring工厂
    @Test
    public void testSpringFactory(){

        //启动Spring容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Calendar calendar = (Calendar) context.getBean("calendar3");
        System.out.println(calendar.getTime());
        System.out.println("我是spring工厂创建的");
    }
}