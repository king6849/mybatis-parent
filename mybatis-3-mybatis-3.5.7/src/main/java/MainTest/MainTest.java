package MainTest;

import MainTest.Entity.User;
import MainTest.Mapper.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainTest {

  public static void main(String[] args) {
    MainTest mainTest=new MainTest();
    try {
      mainTest.findAllTest();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void findAllTest() throws IOException {
    //加载mybatis主配置文件，获取其字节输入流
    InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
    //使用构建者构建SqlSessionFactory对象
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
    //使用SqlSessionFactory对象生产SqlSession
    SqlSession session = factory.openSession();
    //创建dao的代理对象
    TestMapper userDao = session.getMapper(TestMapper.class);
    //执行方法获取结果
    List<User> users = userDao.findAll();
    //遍历展示
    for (User user : users) {
      System.out.println(user);
    }
    //释放资源
    session.close();
    is.close();
  }
}
