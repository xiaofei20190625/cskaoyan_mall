package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.vo.PageVO;

import java.util.List;

public interface AdminService {
    PageVO<Admin> findAdminPage(int page, int limit,String username);

    int roleupdate(Admin admin);

    int admindelete(Admin admin);

    int adminadd(Admin admin);
}
