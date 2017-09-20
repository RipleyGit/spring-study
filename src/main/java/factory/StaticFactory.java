package factory;

import java.util.Calendar;

public class StaticFactory {
	
	//静态工厂本身对象是否创建？？？
	public StaticFactory(){
		System.out.println("我是一个静态工厂");
	}
	
	public static Calendar getCalendar(){
		
		return Calendar.getInstance();
	}
	
}
