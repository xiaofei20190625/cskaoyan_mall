package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.UserVip;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.wx.bean.RegisterUser;


public interface UserVipService {

    PageVO<UserVip> findUserVipPageByUsernameAndMobile(int page, int limit, String username, String mobile, String sort, String order);

    UserVip findUserVip(String username);

    UserVip findUserVipByiD(Integer id);

    int registerUser(UserVip user);
}
