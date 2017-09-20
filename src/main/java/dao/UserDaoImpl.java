package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository  //id:userDaoImpl
public class UserDaoImpl implements UserDao{

	public void addUser() {
		
		System.out.println("添加一个用户");
		
	}
	
}
