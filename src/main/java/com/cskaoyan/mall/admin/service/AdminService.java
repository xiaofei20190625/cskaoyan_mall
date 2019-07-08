package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Admin;
import com.cskaoyan.mall.admin.vo.PageVO;

public interface AdminService {
    PageVO<Admin> findAdminPage(int page, int limit,String username);

    int roleupdate(Admin admin);

    int admindelete(Admin admin);

    int adminadd(Admin admin);

    Admin queryPasswordFromDb(String principal);
}
