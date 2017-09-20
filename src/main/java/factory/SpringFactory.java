package factory;

import java.util.Calendar;

import org.springframework.beans.factory.FactoryBean;

//使用Spring工厂创建对象
public class SpringFactory implements FactoryBean<Calendar>{

	public Calendar getObject() throws Exception {

		return Calendar.getInstance();
	}

	public Class<?> getObjectType() {
		
		return Calendar.class;
	}
	
	//是否单例
	public boolean isSingleton() {
		
		return false;
	}
	
	
}
