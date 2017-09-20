package factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

import static org.junit.Assert.*;

public class StaticFactoryTest {
    //要求：获取日历对象   静态工厂
    @Test
    public void testStaticFactory(){

        //启动Spring容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Calendar calendar = (Calendar) context.getBean("calendar");
        System.out.println(calendar.getTime());
    }

}