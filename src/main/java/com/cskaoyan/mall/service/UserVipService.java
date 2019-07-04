package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.UserVip;
import com.cskaoyan.mall.vo.PageVO;


public interface UserVipService {

    PageVO<UserVip> findUserVipPageByUsernameAndMobile(int page, int limit, String username, String mobile, String sort, String order);
}
