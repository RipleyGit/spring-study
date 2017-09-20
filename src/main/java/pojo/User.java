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

	public User(){
		System.out.println("1.通过无参构造创建对象");
	}

	@PostConstruct  //构造方法之后执行
	public void init(){
		//有时需要在创建对象之后为对象添加操作  流、线程、数据源等
		System.out.println("2.对象的初始化操作");
	}

	public void work(){
		System.out.println("3.对象调用方法执行");
	}

	//在容器销毁之前执行
	@PreDestroy
	public void destroy(){

		System.out.println("4.对象的销毁操作");
	}











}
