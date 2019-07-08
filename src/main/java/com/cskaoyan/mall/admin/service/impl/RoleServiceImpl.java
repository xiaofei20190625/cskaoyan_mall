package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.service.RoleService;
import com.cskaoyan.mall.admin.bean.Role;
import com.cskaoyan.mall.admin.mapper.RoleMapper;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Role> queryOption() {
        List<Role> roles = roleMapper.queryOption();
        return roles;
    }

    @Override
    public PageVO<Role> findRolePage(int page, int limit, String name) {
        PageHelper.startPage(page,limit);
        List<Role> roleList = roleMapper.findRolePage(name);
        PageInfo<Role> rolePageInfo = new PageInfo<>(roleList);
        PageVO<Role> rolePageVO = new PageVO<>(rolePageInfo.getTotal(), rolePageInfo.getList());
        return rolePageVO;
    }

    @Override
    public int roleupdate(Role role) {
      role.setUpdateTime(new Date());
        int update = roleMapper.roleupdate(role);
        return update;
    }
}
