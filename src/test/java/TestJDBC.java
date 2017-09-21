import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {
    private Connection connection= null;
    @Before
    public void before() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        connection = dataSource.getConnection();

    }
    @Test
    public void testJdbc() throws SQLException {

        System.out.println(connection.isClosed());

    }
    //查询结果
    @Test
    public void testRs() throws SQLException {
        String sql = "select * from user";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            User user  = new User();
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.toString();
        }
    }
}
