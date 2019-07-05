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
    public PageVO<Collect> findCollectPageByValueIdAndUserId(int page, int limit, String userId, String valueId, String sort, String order) {
        List<Collect> collects = collectMapper.findCollectPageByValueIdAndUserId(userId,valueId,sort,order);
        PageVO<Collect> collectPageVO = new PageUtil<Collect>().pagevo(page,limit,collects);
        return collectPageVO;
    }
}
