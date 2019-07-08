package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.PageList;
import com.cskaoyan.mall.admin.bean.UserVip;
import com.cskaoyan.mall.admin.mapper.UserVipMapper;
import com.cskaoyan.mall.admin.service.UserVipService;
import com.cskaoyan.mall.admin.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVipServiceImpl implements UserVipService {
    @Autowired
    UserVipMapper userVipMapper;


    @Override
    public PageVO<UserVip> findUserVipPageByUsernameAndMobile(int page, int limit, String username, String mobile, String sort, String order) {
        List<UserVip> userVips = userVipMapper.selectUserVipByUsernameAndMobile(username, mobile, sort ,order);
        PageVO<UserVip> pagevo = new PageList<UserVip>().pagevo(page, limit, userVips);
        return pagevo;
    }
}
