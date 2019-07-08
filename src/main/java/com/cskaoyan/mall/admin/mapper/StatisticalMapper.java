package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.GoodsS;
import com.cskaoyan.mall.admin.bean.OrderS;
import com.cskaoyan.mall.admin.bean.UserS;


import java.util.List;

public interface StatisticalMapper {

    List<UserS> queryUserS();

    List<OrderS> queryOrderS();

    List<GoodsS> queryGoodsS();
}
