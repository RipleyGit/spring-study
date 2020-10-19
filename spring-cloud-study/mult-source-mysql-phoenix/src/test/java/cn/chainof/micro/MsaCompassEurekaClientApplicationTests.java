package cn.chainof.micro;

import cn.chainof.micro.dao.PhoenixDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsaCompassEurekaClientApplicationTests {

	@Autowired
	private PhoenixDao populationDao;

	@Test
	public void queryAll() {
		List<Object> USPopulationList = populationDao.queryAll();
		System.out.printf("ii:"+USPopulationList);
	}

}
