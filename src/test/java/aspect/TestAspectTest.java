package aspect;

import controller.UserController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import tx.TranscationManager;

import static org.junit.Assert.*;

public class TestAspectTest {

    @Test
    public void testAspect(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-v2.0.xml");
        UserController userController = (UserController) context.getBean("userController");
        userController.addUser();
    }
}