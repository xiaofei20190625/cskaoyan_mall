package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Permissions;
import com.cskaoyan.mall.admin.bean.Role;
import com.cskaoyan.mall.admin.vo.PageVO;

import java.util.List;

public interface RoleService {
    List<Role> queryOption();

    PageVO<Role> findRolePage(int page, int limit, String name);

    int roleupdate(Role role);

    Role queryRole(int roleId);

    Permissions querypermissions(Integer roleId);
}
