package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.SysPermissions;

public interface SysPermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPermissions record);

    int insertSelective(SysPermissions record);

    SysPermissions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPermissions record);

    int updateByPrimaryKey(SysPermissions record);
}