package cn.zl.mapper;

import cn.zl.entity.Salgrade;

public interface SalgradeMapper {
    int insert(Salgrade record);

    int insertSelective(Salgrade record);
}