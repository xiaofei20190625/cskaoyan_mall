package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.vo.SysPermissionVO;
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

    List<Role> findRolePage(@Param("name") String name);

    int roleupdate(Role role);

    Role queryRole(@Param("roleId") int roleId);

    List querypermissions(@Param("roleId") int roleId);

    List<SysPermission2> systemPermissinons(int roleId);

    List<PermissionApi> querypermissionsApi(int roleId);
}