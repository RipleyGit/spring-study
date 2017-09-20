package service;

import org.springframework.stereotype.Service;

@Service(value="userService")    //指定bean的ID为userService
public class UserServiceImplA implements UserService {

	@Override
	public void addUser() {
		
		System.out.println("添加用户A");
		
	}

}
