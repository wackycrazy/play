package cn.zl.mapper;

import cn.zl.entity.Dept;

public interface DeptMapper {
    int insert(Dept record);

    int insertSelective(Dept record);
}