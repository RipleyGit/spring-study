package pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class User {
	//为引用赋值
	private Dog dog;
	private Cat cat;
	
	
	//为简单类型赋值
	private Integer id;    //100
	private String name;   //孙尚香
	
	private List list;
	private Set set;
	private Map map;
	private Properties pro;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Set getSet() {
		return set;
	}
	public void setSet(Set set) {
		this.set = set;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Properties getPro() {
		return pro;
	}
	public void setPro(Properties pro) {
		this.pro = pro;
	}
	
	
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public Cat getCat() {
		return cat;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	@Override
	public String toString() {
		return "User [dog=" + dog + ", cat=" + cat + ", id=" + id + ", name="
				+ name + ", list=" + list + ", set=" + set + ", map=" + map
				+ ", pro=" + pro + "]";
	}
	
	
	
	
	
	
	
}
