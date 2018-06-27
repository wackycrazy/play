package cn.zl.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import cn.zl.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByAccount(String account);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @Update("update t_user set name = #{name} where id = #{id}")
    @Transactional
    int updateName(@Param("id") Long userId, @Param("name") String name);
}