package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import service.UserService;

@Controller
public class UserController {
//    public UserController(){
//        System.out.println("spring 框架 主要是通过反射调用来创建bean 进行管理。反射式通过类的无参构造函数来创建对象的！");
//    }
//    public void hello(){
//        System.out.println("hello I am a spring bean!");
// /    }
    @Autowired  //2种注入方式   byName  byType
    @Qualifier("userServiceB")
    private UserService userService;  //面向接口编程


    public void addUser(){
        userService.addUser();
    }
}
