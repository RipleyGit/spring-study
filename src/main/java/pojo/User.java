package pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component(value="tom")  //表示当前类交给spring容器管理
//@Scope(value="protoType")  //对象的单例和多例
//@Lazy(true)		//表示懒加载
/*@Controller     //控制层的注解
@Service		//业务层注解
@Repository		//持久层的注解
*/

//需求：要求为对象指定ID     user--tom   bean id=tom

public class User {
	private int id;
	private String name;

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
