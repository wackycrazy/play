package cn.zl.mapper;

import cn.zl.entity.Emp;

public interface EmpMapper {
    int insert(Emp record);

    int insertSelective(Emp record);
}