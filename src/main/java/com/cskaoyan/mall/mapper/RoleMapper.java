package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    List<Role> queryOption();

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

}