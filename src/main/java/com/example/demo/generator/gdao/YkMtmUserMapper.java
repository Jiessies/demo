package com.example.demo.generator.gdao;

import com.example.demo.generator.gentry.YkMtmUser;

public interface YkMtmUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YkMtmUser record);

    int insertSelective(YkMtmUser record);

    YkMtmUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YkMtmUser record);

    int updateByPrimaryKey(YkMtmUser record);
}