package pojo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component   //理论值：nBA    
public class nBA implements BeanNameAware{
	
	//作用:回显bean的Id
	public void setBeanName(String name) {
		
		System.out.println("当前bean的id为："+name);
		
	}
	
	
}
