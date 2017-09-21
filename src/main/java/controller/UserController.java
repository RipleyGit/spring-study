package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import service.UserService;

@Controller
public class UserController {
    @Autowired  //2种注入方式   byName  byType
    private UserService userService;  //面向接口编程


    public void addUser(){
        userService.addUser();
    }

    public void addThrow() {
        userService.addThrow();
    }
}
