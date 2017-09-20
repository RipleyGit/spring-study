package controller;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Product;

import static org.junit.Assert.*;

public class UserControllerValue {
    @Test
    public void test01(){

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-v1.7.xml");
        UserController userController = (UserController) context.getBean("userController");

        userController.addUser();

    }


    //测试value赋值
    @Test
    public void test02(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-v1.7.xml");
        Product product = (Product) context.getBean("product");
        System.out.println(product);
    }

}