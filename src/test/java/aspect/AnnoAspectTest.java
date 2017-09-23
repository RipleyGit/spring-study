package aspect;

import controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class AnnoAspectTest {
    private static ApplicationContext context;
    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("applicationContext-v2.2.xml");
    }

    @Test
    public void testAround() {
        UserController userController = (UserController) context.getBean("userController");
        userController.addUser();
    }

}