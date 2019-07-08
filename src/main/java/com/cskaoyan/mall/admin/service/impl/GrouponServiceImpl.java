package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Groupon;
import com.cskaoyan.mall.admin.mapper.GrouponMapper;
import com.cskaoyan.mall.admin.service.GrouponService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/7/5 15:44
 * @Description TODO
 */
@Service
public class GrouponServiceImpl implements GrouponService {
    @Autowired
    GrouponMapper grouponMapper ;

    @Override
    public PageVO<Groupon> getListRecord(int page, int limit, String sort, String order, String goodsId) {
        PageHelper.startPage(page, limit);
        List<Groupon> orderList = grouponMapper.getListRecord(sort , order ,goodsId  );
        PageInfo<Groupon> grouponPageInfo = new PageInfo<>(orderList);
        PageVO<Groupon> grouponPageVO = new PageVO<>(grouponPageInfo.getTotal(),grouponPageInfo.getList());
        return  grouponPageVO ;
    }
}
