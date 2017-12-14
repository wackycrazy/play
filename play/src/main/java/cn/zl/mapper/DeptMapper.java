package cn.zl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.zl.entity.Dept;

@Mapper
public interface DeptMapper {
    int insert(Dept record);

    int insertSelective(Dept record);
    
    List<Dept> getAll();
}