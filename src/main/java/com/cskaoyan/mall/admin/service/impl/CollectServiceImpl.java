package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.PageList;
import com.cskaoyan.mall.admin.mapper.CollectMapper;
import com.cskaoyan.mall.admin.service.CollectService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.bean.Collect;
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
        PageVO<Collect> collectPageVO = new PageList<Collect>().pagevo(page,limit,collects);
        return collectPageVO;
    }
}
