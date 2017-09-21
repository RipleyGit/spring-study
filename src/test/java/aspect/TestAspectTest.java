package aspect;

import controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import tx.TranscationManager;

import static org.junit.Assert.*;

public class TestAspectTest {
    private static ApplicationContext context;
    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("applicationContext-v2.1.xml");
    }

    @Test
    public void testAspect(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-v2.0.xml");
        UserController userController = (UserController) context.getBean("userController");
        userController.addUser();
    }

    @Test
    public void testAspectAdviceThrow() {
        UserController userController = (UserController) context.getBean("userController");
        userController.addThrow();

    }
}