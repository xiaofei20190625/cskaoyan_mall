package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.mapper.AdminMapper;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.utils.MD5Utils;
import com.cskaoyan.mall.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public PageVO<Admin> findAdminPage(int page, int limit, String username) {
        PageHelper.startPage(page,limit);
        List<Admin> adminList = adminMapper.findAdminPage(username);
        PageInfo<Admin> adminPageInfo = new PageInfo<>(adminList);
        PageVO<Admin> adminPageVO = new PageVO<>(adminPageInfo.getTotal(), adminPageInfo.getList());
        return adminPageVO;
    }

    @Override
    public int roleupdate(Admin admin) {
        admin.setUpdateTime(new Date());
        String password = admin.getPassword();
        String md5 = MD5Utils.getMD5(password);
        admin.setPassword(md5);
        int update = adminMapper.roleupdate(admin);
        return update;
    }

    @Override
    public int admindelete(Admin admin) {
        admin.setDeleted(true);
        int delete = adminMapper.admindelete(admin);
        return delete;
    }

    @Override
    public int adminadd(Admin admin) {
        admin.setAddTime(new Date());
        String password = admin.getPassword();
        String md5 = MD5Utils.getMD5(password);
        admin.setPassword(md5);
        int add= adminMapper.adminadd(admin);
        return add;
    }


}
