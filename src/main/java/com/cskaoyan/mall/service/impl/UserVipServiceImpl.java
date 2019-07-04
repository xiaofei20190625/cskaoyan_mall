package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.UserVip;
import com.cskaoyan.mall.mapper.UserVipMapper;
import com.cskaoyan.mall.service.UserVipService;
import com.cskaoyan.mall.vo.PageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVipServiceImpl implements UserVipService {
    @Autowired
    UserVipMapper userVipMapper;

    @Override
    public PageVO<UserVip> findUserVipPage(int pag, int limit) {
        PageHelper.startPage(pag,limit);
        List<UserVip> userVips = userVipMapper.selectUserVip();
        PageInfo<UserVip> userVipPageInfo = new PageInfo<>(userVips);
        PageVO<UserVip> userVipPageVO = new PageVO<>(userVipPageInfo.getTotal(), userVipPageInfo.getList());
        return userVipPageVO;
    }

    @Override
    public PageVO<UserVip> findUserVipPageByUsernameAndMobile(int page, int limit, String username, String mobile) {
        PageHelper.startPage(page,limit);
        List<UserVip> userVips = userVipMapper.selectUserVipByUsernameAndMobile(username, mobile);
        PageInfo<UserVip> userVipPageInfo = new PageInfo<>(userVips);
        PageVO<UserVip> userVipPageVO = new PageVO<>(userVipPageInfo.getTotal(), userVipPageInfo.getList());
        return userVipPageVO;
    }

    @Override
    public PageVO<UserVip> findUserVipPageByUsername(int page, int limit, String username) {
        PageHelper.startPage(page,limit);
        List<UserVip> userVips = userVipMapper.selectUserVipByUsername(username);
        PageInfo<UserVip> userVipPageInfo = new PageInfo<>(userVips);
        PageVO<UserVip> userVipPageVO = new PageVO<>(userVipPageInfo.getTotal(), userVipPageInfo.getList());
        return userVipPageVO;
    }

    @Override
    public PageVO<UserVip> findUserVipPageByMobile(int page, int limit, String mobile) {
        PageHelper.startPage(page,limit);
        List<UserVip> userVips = userVipMapper.selectUserVipByMobile(mobile);
        PageInfo<UserVip> userVipPageInfo = new PageInfo<>(userVips);
        PageVO<UserVip> userVipPageVO = new PageVO<>(userVipPageInfo.getTotal(), userVipPageInfo.getList());
        return userVipPageVO;
    }
}
