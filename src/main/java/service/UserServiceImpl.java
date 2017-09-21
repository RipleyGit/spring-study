package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;


	public void addUser() {
		
		userDao.addUser();
	}
	public void addThrow(){
		System.out.println("the will happen exception!");
		int i = 1/0;
	}

}
