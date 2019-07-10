package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.RoleMapper;
import com.cskaoyan.mall.admin.service.RoleService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.SysPermissionVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        //字符串拼起来用%号，后面xml就可以用#来查询
        if (name != null) {
            name="%"+name+"%";
        }
//        List<Role> roleList = roleMapper.findRolePage(name);
        List<Role> roleList = roleMapper.getRolePage(name);
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

    @Override
    public Role queryRole(int roleId) {
        return roleMapper.queryRole(roleId);
    }

    @Override
    public Permissions querypermissions(Integer roleId) {
        List assignedPermissions = roleMapper.querypermissions(roleId);
        List<SysPermissionVO<SysPermissionVO<PermissionApi>>> sysPermissionVOS = new ArrayList<>();


        List<SysPermission2> sysPermissionVOList= roleMapper.systemPermissinons(roleId);
        for (SysPermission2 sysPermissionVOSysPermissionVO : sysPermissionVOList) {
            SysPermissionVO<SysPermissionVO<PermissionApi>> sysPermissionVOSysPermissionVO1 = new SysPermissionVO<>();

            sysPermissionVOSysPermissionVO1.setLabel(sysPermissionVOSysPermissionVO.getLabel());
            sysPermissionVOSysPermissionVO1.setId(sysPermissionVOSysPermissionVO.getId());

            List<SysPermission1> children = sysPermissionVOSysPermissionVO.getChildren();
            List<SysPermissionVO<PermissionApi>> sysPermissionVOS1 = new ArrayList<>();
            for (SysPermission1 child : children) {
                int children1 = child.getChildren();
                SysPermissionVO<PermissionApi> permissionApiSysPermissionVO = new SysPermissionVO<>();

                List<PermissionApi> permissionApis =roleMapper.querypermissionsApi(children1);
                permissionApiSysPermissionVO.setChildren(permissionApis);

                sysPermissionVOS1.add(permissionApiSysPermissionVO);
            }
            sysPermissionVOSysPermissionVO1.setChildren(sysPermissionVOS1);
            sysPermissionVOS.add(sysPermissionVOSysPermissionVO1);
        }
        Permissions permissions = new Permissions();
        permissions.setAssignedPermissions(assignedPermissions);
        permissions.setSystemPermissions(sysPermissionVOS);
        return permissions;
    }


}