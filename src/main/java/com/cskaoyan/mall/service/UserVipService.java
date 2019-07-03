package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.UserVip;
import com.cskaoyan.mall.vo.PageVO;


public interface UserVipService {
    PageVO<UserVip> findUserVipPage(int pag, int limit);
}
