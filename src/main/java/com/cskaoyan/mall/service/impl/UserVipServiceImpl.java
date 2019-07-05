package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.PageList;
import com.cskaoyan.mall.bean.UserVip;
import com.cskaoyan.mall.mapper.UserVipMapper;
import com.cskaoyan.mall.service.UserVipService;
import com.cskaoyan.mall.vo.PageVO;
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
