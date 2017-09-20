package pojo;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component  //id:product
public class Product {
	
	@Value("${id}")
	private Integer id;
	
	@Value("${name}")
	private String name;
	
	@Value("#{@list}")
	private List list;
	
	@Value("#{@set}")
	private Set set;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", list=" + list
				+ ", set=" + set + "]";
	}

	

	
	
	
	
}
