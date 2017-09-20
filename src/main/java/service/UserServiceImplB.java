package service;

import org.springframework.stereotype.Service;

@Service(value="userServiceB")  //指定bean的Id为UserServiceB
public class UserServiceImplB implements UserService{

	@Override
	public void addUser() {
		System.out.println("添加用户B");
		
	}

}
