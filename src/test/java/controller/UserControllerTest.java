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

}
