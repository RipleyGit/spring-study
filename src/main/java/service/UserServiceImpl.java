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

}
