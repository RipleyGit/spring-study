package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;


	public void addUser() {
		
		userDao.addUser();
	}
	public void addThrow(){
		System.out.println("the will happen exception!");
		int i = 1/0;//制造人工异常
	}

	public String adviceStu() {
		return "this is a msg of afterReturning!";
	}
}
