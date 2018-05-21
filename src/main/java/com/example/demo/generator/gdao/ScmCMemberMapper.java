package com.example.demo.generator.gdao;

import com.example.demo.generator.gentry.ScmCMember;

public interface ScmCMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScmCMember record);

    int insertSelective(ScmCMember record);

    ScmCMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScmCMember record);

    int updateByPrimaryKey(ScmCMember record);
}