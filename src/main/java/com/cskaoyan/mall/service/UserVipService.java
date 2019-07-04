package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.UserVip;
import com.cskaoyan.mall.vo.PageVO;


public interface UserVipService {
    PageVO<UserVip> findUserVipPage(int pag, int limit);

    PageVO<UserVip> findUserVipPageByUsernameAndMobile(int page, int limit, String username, String mobile);

    PageVO<UserVip> findUserVipPageByUsername(int page, int limit, String username);

    PageVO<UserVip> findUserVipPageByMobile(int page, int limit, String mobile);
}
