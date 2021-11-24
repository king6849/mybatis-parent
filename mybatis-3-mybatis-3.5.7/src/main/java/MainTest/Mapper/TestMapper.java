package MainTest.Mapper;

import MainTest.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestMapper {

  List<User> findAll();

  User findUserById(int id);

  void addUser(@Param("name")String name, @Param("age")Integer age);

}
