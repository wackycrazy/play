package cn.zl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.zl.entity.User;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM user")
    @Results({
        @Result(property = "age",  column = "age"),
        @Result(property = "name", column = "name")
    })
    List<User> getAll();

    @Insert("INSERT INTO user(name,age) VALUES(#{name}, #{age})")
    void insert(User user);
}
