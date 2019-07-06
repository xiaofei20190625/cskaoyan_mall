package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.vo.PageVO;

import java.util.List;

public interface RoleService {
    List<Role> queryOption();

    PageVO<Role> findRolePage(int page, int limit, String name);

    int roleupdate(Role role);
}
