package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    List<Role> queryOption();

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> findRolePage(@Param("name")String name);

    int roleupdate(Role role);
}