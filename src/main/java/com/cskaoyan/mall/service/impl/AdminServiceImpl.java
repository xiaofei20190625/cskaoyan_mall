package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.mapper.AdminMapper;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public PageVO<Admin> findAdminPage(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Admin> adminList = adminMapper.findAdminPage();
        PageInfo<Admin> adminPageInfo = new PageInfo<>(adminList);
        PageVO<Admin> adminPageVO = new PageVO<>(adminPageInfo.getTotal(), adminPageInfo.getList());
        return adminPageVO;
    }

    @Override
    public int roleupdate(Admin record) {
        int update = adminMapper.roleupdate(record);
        return update;
    }

    @Override
    public int admindelete(Admin id) {
        int delete = adminMapper.admindelete(id);
        return delete;
    }


}
