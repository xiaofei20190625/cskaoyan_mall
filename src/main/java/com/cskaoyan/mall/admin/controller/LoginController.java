package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.Admin;
import com.cskaoyan.mall.admin.bean.Permission;
import com.cskaoyan.mall.admin.bean.Role;
import com.cskaoyan.mall.admin.bean.User;
import com.cskaoyan.mall.admin.service.AdminService;
import com.cskaoyan.mall.admin.service.PermissionService;
import com.cskaoyan.mall.admin.service.RoleService;
import com.cskaoyan.mall.admin.shiro.AdminRealm;
import com.cskaoyan.mall.admin.vo.LoginVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("admin")
public class LoginController {

    @Autowired
    AdminService adminService;
    @Autowired
    AdminRealm adminRealm;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    User user;

    @RequestMapping("auth/login")
    @ResponseBody
    public LoginVO<String> login(@RequestBody Admin admin){
        String username = admin.getUsername();
        String password = admin.getPassword();
        LoginVO<String> loginVO = new LoginVO<>();
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            String id = (String) subject.getSession().getId();
            loginVO.setData(id);
            loginVO.setErrmsg("成功");
            loginVO.setErrno(0);
        }catch (Exception e)
        {
            loginVO.setErrmsg("失败");
            loginVO.setErrno(-1);

        }



        return loginVO;
    }

    @RequestMapping("auth/info")
    @ResponseBody
    public LoginVO<User> loginInfo(String token){
        LoginVO<User> userLoginVO = new LoginVO<>();
        Subject subject = SecurityUtils.getSubject();
        Admin admin = (Admin) subject.getPrincipal();
        user.setAvatar(admin.getAvatar());
        user.setName(admin.getUsername());
        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();

        int[] roleIds = admin.getRoleIds();
        for (int roleId : roleIds) {
            Role role = roleService.queryRole(roleId);
            String name = role.getName();
            roleSet.add(name);
            List<Permission> permissions = permissionService.queryPermission(roleId);
            for (Permission permission : permissions) {
                String permissionName = permission.getPermission();
                permissionSet.add(permissionName);
            }
        }
        user.setPerms(permissionSet);
        user.setRoles(roleSet);
        try {
            userLoginVO.setData(user);
            userLoginVO.setErrmsg("成功");
            userLoginVO.setErrno(0);
        }catch (Exception e)
        {
            userLoginVO.setErrmsg("失败");
            userLoginVO.setErrno(-1);

        }
        return userLoginVO;
    }


    /*/admin/auth/logout*/
    @RequestMapping("auth/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "auth/login";
    }
}
