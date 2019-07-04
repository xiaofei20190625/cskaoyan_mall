package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Address;
import com.cskaoyan.mall.bean.Collect;
import com.cskaoyan.mall.mapper.CollectMapper;
import com.cskaoyan.mall.service.CollectService;
import com.cskaoyan.mall.utils.PageUtil;
import com.cskaoyan.mall.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;
    @Override
    public PageVO<Collect> findCollectPage(int page, int limit) {
        List<Collect> collects = collectMapper.findCollectPage();
        PageVO<Collect> collectPageVO = new PageUtil<Collect>().pagevo(page,limit,collects);
        return collectPageVO;
    }

    @Override
    public PageVO<Collect> findCollectByUserId(int page, int limit, String userId) {
        List<Collect> collects = collectMapper.findCollectByUserId(userId);
        PageVO<Collect> collectPageVO = new PageUtil<Collect>().pagevo(page,limit,collects);
        return collectPageVO;
    }

    @Override
    public PageVO<Collect> findCollectPageByValueIdAndUserId(int page, int limit, String userId, String valueId) {
        List<Collect> collects = collectMapper.findCollectPageByValueIdAndUserId(userId,valueId);
        PageVO<Collect> collectPageVO = new PageUtil<Collect>().pagevo(page,limit,collects);
        return collectPageVO;
    }

    @Override
    public PageVO<Collect> findCollectPageByValueId(int page, int limit, String valueId) {
        List<Collect> collects = collectMapper.findCollectPageByValueId(valueId);
        PageVO<Collect> collectPageVO = new PageUtil<Collect>().pagevo(page,limit,collects);
        return collectPageVO;
    }
}
