package cn.zl.mapper;

import cn.zl.entity.Bonus;

public interface BonusMapper {
    int insert(Bonus record);

    int insertSelective(Bonus record);
}