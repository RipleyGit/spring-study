package pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  //表示当前类交给spring容器管理
public class User {
	
	@Autowired
	private Dog dog;

	@Autowired
	private Cat cat;
	

	@Override
	public String toString() {
		return "User [dog=" + dog + ", cat=" + cat + "]";
	}
	
	
	
	
	
	
	
	


	
	
	
}
