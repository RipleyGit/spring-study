package controller;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserControllerTest {
    @Test
    public void testBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = (UserController) context.getBean("user");
        userController.hello();
    }
    //测试对象的单例和多例
    @Test
    public void testScope(){

        //启动Spring容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController user1 = (UserController) context.getBean("user");
        UserController user2 = (UserController) context.getBean("user");
        UserController user3 = (UserController) context.getBean("user");

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

    }

}
